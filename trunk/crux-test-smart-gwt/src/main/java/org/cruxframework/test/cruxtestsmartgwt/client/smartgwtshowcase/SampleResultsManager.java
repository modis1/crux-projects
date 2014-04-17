package org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.UmbrellaException;

import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.client.widgets.viewer.DetailViewer;

public class SampleResultsManager implements UncaughtExceptionHandler {

    private static final int DETAILS_STACK_DEPTH = 10;

    // referenced widgets
    private Canvas panel;
    private Canvas parent;
    private Canvas viewer;

    // results to be presented
    private String description;
    private DetailsReport report;

    // current sample test state
    private int pendingRPCs;
    private boolean allComplete;
    private boolean evalComplete;

    // saved handlers allow reinstall after sample test
    private JavaScriptObject         oldErrorHandler;
    private JavaScriptObject         oldRPCErrorHandler;
    private JavaScriptObject         oldTransformResponse;
    private JavaScriptObject         oldTransformRequest;
    private JavaScriptObject         oldTransactionComplete;
    private UncaughtExceptionHandler oldExceptionHandler;

    // manage sample created by factory, hang results off canvas 'parent'
    private SampleResultsManager(PanelFactory factory, Canvas parent) {
        description = factory.getDescription();
        report = new DetailsReport();
        this.parent = parent;
        attachExceptionHandler();
        attachErrorHandler();
        attachRPCHandlers();
        attachJavaScriptHooks();
        requestCallback();
    }
    
    // uninstaller handles and display DetailViewer
    private void completeResultsCollection() {
        detachJavaScriptHooks();
        detachRPCHandlers();
        detachErrorHandler();
        detachExceptionHandler();
        addDetailViewerForTestResults();
        allComplete = true;
    }

    // create DetailViewer for sample test results
    private void addDetailViewerForTestResults() {
        viewer = createDetailViewerForTestResults();
        JSOHelper.setAttribute(viewer.getJsObj(), SC.REF, viewer);
        parent.addChild(viewer);
        viewer.setTop(50);
    }

    private native boolean isSystemDone() /*-{
        var autoTest = $wnd.isc.AutoTest;
        return autoTest ? autoTest.isSystemDone(true) : true;
    }-*/;

    private boolean isWidgetInStableState() {
        if (!report.isEmpty() || panel == null) {
            return true;
        }
        return panel.isDrawn() && !panel.isDirty() && isSystemDone();
    }

    // track pending RPCs
    private void incrementRPCs() {
        pendingRPCs++;
    }
    private void decrementRPCs() {
        pendingRPCs--;
    }

    // collect reported errors
    private  void reportError(String error) {
        report.addDetails(error + "\n");
    }

    private void reportException(Throwable t) {
        String details = t.toString();
        StackTraceElement[] trace = t.getStackTrace();
        for (int i = 0; i < Math.min(trace.length, DETAILS_STACK_DEPTH); i++ ) {
            details += "\n" + trace[i];
        }
        reportError(details);
    }

    public void onUncaughtException(Throwable t) {
        if (t instanceof UmbrellaException) {
            UmbrellaException uncaught = (UmbrellaException) t;
            Throwable[] exceptions = uncaught.getCauses().toArray(new Throwable[0]);
            for (int i = 0; i < exceptions.length; i++) reportException(exceptions[i]);
        } else {
            reportException(t);
        }
    }
    
    // if original stability check already completed,
    // and RPCs just now fell to zero, redo the check
    private void completeRPCs() {
        if (pendingRPCs <= 0 && evalComplete) {
            evalComplete = false;
            requestCallback();
        }
    }
    
    // if widget is not stable, check again after quiescence;
    // otherwise if no RPCs, prepare results for DetailViewer
    private void checkForCompletion() {
        if (isWidgetInStableState()) {
            evalComplete = true;
            if (pendingRPCs <= 0) {
                completeResultsCollection();
            }
        } else {
            requestCallback();     
        }
    }

    private void destroy() {
        if (!allComplete) {
            detachJavaScriptHooks();
            detachRPCHandlers();
            detachErrorHandler();
            detachExceptionHandler();
            allComplete = true;
        } else if (viewer != null) {
            viewer.destroy();
            viewer = null;
        }
    }

     private native void requestCallback() /*-{
        var wrapper = this;
        var callback = $entry(function() {
            if (!wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::allComplete) {
                wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::checkForCompletion()();
            }
        });
        var parent = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::parent;
        var object = parent.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        object.fireOnPause("checkForCompletion", callback);
    }-*/;

    private void attachExceptionHandler() {
        oldExceptionHandler = GWT.getUncaughtExceptionHandler();
        GWT.setUncaughtExceptionHandler(this);
    }

    private void detachExceptionHandler() {
        GWT.setUncaughtExceptionHandler(oldExceptionHandler);        
    }

    private native void attachErrorHandler() /*-{
        var wrapper = this;
        this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldErrorHandler = $wnd.onerror;
        $wnd.onerror = $entry(function(msg, url, line) {
            var error = "Javascript Exception at " + url + ", line " + line + ": " + msg;
            wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::reportError(Ljava/lang/String;)(error);
            return true;
        });
    }-*/;

    private native void detachErrorHandler() /*-{
        var oldErrorHandler = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldErrorHandler;
        if (oldErrorHandler != null) {
            this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldErrorHandler = null;
            $wnd.onerror = oldErrorHandler;
        }
    }-*/;

    private native void attachRPCHandlers() /*-{
        var rpc = $wnd.isc.RPCManager;
        this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldRPCErrorHandler     = rpc.reportError;
        this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransformRequest    = rpc.transformRequest;
        this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransformResponse   = rpc.transformResponse;
        this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransactionComplete = rpc.transactionComplete;

        var wrapper = this;
        rpc.reportError = $entry(function (error) {
            wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::reportError(Ljava/lang/String;)(error);
        });
        rpc.transformRequest = $entry(function (rpcRequest) {
            wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::incrementRPCs()();
            return rpcRequest.data;
        });
        rpc.transformResponse = $entry(function (rpcResponse, rpcRequest, data) {
            wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::decrementRPCs()();
            return rpcResponse;
        });
        rpc.transactionComplete = $entry(function () {
            wrapper.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::completeRPCs()();
        });
    }-*/;

    private native void detachRPCHandlers() /*-{
        var rpc = $wnd.isc.RPCManager;
        rpc.reportError         = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldRPCErrorHandler;
        rpc.transformRequest    = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransformRequest;
        rpc.transformResponse   = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransformResponse;
        rpc.transactionComplete = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::oldTransactionComplete;
    }-*/;

    private native DetailViewer createDetailViewerForTestResults() /*-{
        var text = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::description,
            report = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::report,
            errors = report.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.DetailsReport::toString()();
        var results = { result : errors.length > 0 ? "failure" : "success",
                        description : text,
                        detail : errors };
        var parent = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::parent,
            parentJsObj = parent.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()(),
            viewerJsObj = $wnd.isc.AutoTest.createDetailViewerForTestResults(parentJsObj, results),
            viewer = @com.smartgwt.client.widgets.viewer.DetailViewer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(viewerJsObj);
        viewer.@com.smartgwt.client.widgets.viewer.DetailViewer::doInit()();
        return viewer;
    }-*/;

    private native void attachJavaScriptHooks() /*-{
        var report = this.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::report;
        $wnd.isc_Showcase_1_0.getDetailsReport = $entry(function () {
            return report.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.DetailsReport::toString()();
        })
    }-*/;

    private native void detachJavaScriptHooks() /*-{
        delete $wnd.isc_Showcase_1_0.getDetailsReport;
    }-*/;

    // singleton paradigm for SampleResultsManager

    private static SampleResultsManager singleton;

    private static SampleResultsManager getSingleton(PanelFactory factory, Canvas parent) {
        destroySingletonAndInstallDestroyEntryPoint();
        singleton = new SampleResultsManager(factory, parent);
        return singleton;
    }

    private static native void destroySingletonAndInstallDestroyEntryPoint() /*-{
        var destroyFunction = $entry(function () {
            var singleton = @org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::singleton;
            if (singleton) {
                singleton.@org.cruxframework.test.cruxtestsmartgwt.client.smartgwtshowcase.SampleResultsManager::destroy()();
            }
        });
        if ($wnd.isc_Showcase_1_0.destroySampleResultsManager == null) {
            $wnd.isc_Showcase_1_0.destroySampleResultsManager = destroyFunction;
        }
        destroyFunction();
    }-*/;

    // Collects new results, replacing the previous SampleResultsManager
    public static Canvas create(TabSet tabSet, PanelFactory factory) {
        SampleResultsManager results = getSingleton(factory, tabSet);
        // avoid huge population of tabs
        Tab tab0 = tabSet.getTab(1);
        if (tab0 != null) {
            tabSet.removeTab(tab0);
        }
        // create the sample canvas under test
        try {
            results.panel = factory.create();
        } catch (Exception e) {
            results.onUncaughtException(e);
        }
        return results.panel;
    }
}