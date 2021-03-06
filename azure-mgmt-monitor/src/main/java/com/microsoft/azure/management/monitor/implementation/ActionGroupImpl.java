/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.monitor.implementation;

import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.monitor.ActionGroup;
import com.microsoft.azure.management.monitor.AutomationRunbookReceiver;
import com.microsoft.azure.management.monitor.AzureAppPushReceiver;
import com.microsoft.azure.management.monitor.AzureFunctionReceiver;
import com.microsoft.azure.management.monitor.EmailReceiver;
import com.microsoft.azure.management.monitor.ItsmReceiver;
import com.microsoft.azure.management.monitor.LogicAppReceiver;
import com.microsoft.azure.management.monitor.SmsReceiver;
import com.microsoft.azure.management.monitor.VoiceReceiver;
import com.microsoft.azure.management.monitor.WebhookReceiver;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceUtils;
import com.microsoft.azure.management.resources.fluentcore.arm.models.implementation.GroupableResourceImpl;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Implementation for ActionGroup.
 */
@LangDefinition
class ActionGroupImpl
        extends GroupableResourceImpl<
            ActionGroup,
            ActionGroupResourceInner,
            ActionGroupImpl,
            MonitorManager>
        implements
            ActionGroup,
            ActionGroup.Definition,
            ActionGroup.Update,
            ActionGroup.UpdateStages.WithActionUpdateDefinition {
    private final String emailSuffix = "_-EmailAction-";
    private final String smsSuffix = "_-SMSAction-";
    private final String appActionSuffix = "_-AzureAppAction-";
    private final String voiceSuffix = "_-VoiceAction-";
    private final String runBookSuffix = " (RB)";
    private final String logicSuffix = " (LA)";
    private final String functionSuffix = " (F)";
    private final String webhookSuffix = " (WH)";
    private final String itsmSuffix = " (ITSM)";

    private String actionReceiverPrefix;
    private TreeMap<String, EmailReceiver> emailReceivers;
    private TreeMap<String, SmsReceiver> smsReceivers;
    private TreeMap<String, AzureAppPushReceiver> appActionReceivers;
    private TreeMap<String, VoiceReceiver> voiceReceivers;
    private TreeMap<String, AutomationRunbookReceiver> runBookReceivers;
    private TreeMap<String, LogicAppReceiver> logicReceivers;
    private TreeMap<String, AzureFunctionReceiver> functionReceivers;
    private TreeMap<String, WebhookReceiver> webhookReceivers;
    private TreeMap<String, ItsmReceiver> itsmReceivers;

    ActionGroupImpl(String name, final ActionGroupResourceInner innerModel, final MonitorManager monitorManager) {
        super(name, innerModel, monitorManager);
        this.actionReceiverPrefix = "";
        this.emailReceivers = new TreeMap<>();
        this.smsReceivers = new TreeMap<>();
        this.appActionReceivers = new TreeMap<>();
        this.voiceReceivers = new TreeMap<>();
        this.runBookReceivers = new TreeMap<>();
        this.logicReceivers = new TreeMap<>();
        this.functionReceivers = new TreeMap<>();
        this.webhookReceivers = new TreeMap<>();
        this.itsmReceivers = new TreeMap<>();
        if (isInCreateMode()) {
            this.inner().withEnabled(true);
            this.inner().withGroupShortName(this.name().substring(0, (this.name().length() > 12) ? 12 : this.name().length()));
        } else {
            this.withExistingResourceGroup(ResourceUtils.groupFromResourceId(this.id()));
        }
    }

    @Override
    public String shortName() {
        return this.inner().groupShortName();
    }

    @Override
    public List<EmailReceiver> emailReceivers() {
        return this.inner().emailReceivers();
    }

    @Override
    public List<SmsReceiver> smsReceivers() {
        return this.inner().smsReceivers();
    }

    @Override
    public List<WebhookReceiver> webhookReceivers() {
        return this.inner().webhookReceivers();
    }

    @Override
    public List<ItsmReceiver> itsmReceivers() {
        return this.inner().itsmReceivers();
    }

    @Override
    public List<AzureAppPushReceiver> azureAppPushReceivers() {
        return this.inner().azureAppPushReceivers();
    }

    @Override
    public List<AutomationRunbookReceiver> automationRunbookReceivers() {
        return this.inner().automationRunbookReceivers();
    }

    @Override
    public List<VoiceReceiver> voiceReceivers() {
        return this.inner().voiceReceivers();
    }

    @Override
    public List<LogicAppReceiver> logicAppReceivers() {
        return this.inner().logicAppReceivers();
    }

    @Override
    public List<AzureFunctionReceiver> azureFunctionReceivers() {
        return this.inner().azureFunctionReceivers();
    }

    @Override
    public ActionGroupImpl withoutReceiver(String actionNamePrefix) {
        this.updateReceiver(actionNamePrefix);
        this.withoutEmail();
        this.withoutSms();
        this.withoutAzureAppPush();
        this.withoutVoice();
        this.withoutAutomationRunbook();
        this.withoutLogicApp();
        this.withoutAzureFunction();
        this.withoutWebhook();
        this.withoutItsm();

        return this.parent();
    }

    @Override
    public ActionGroupImpl defineReceiver(String actionNamePrefix) {
        return this.updateReceiver(actionNamePrefix);
    }

    @Override
    public ActionGroupImpl updateReceiver(String actionNamePrefix) {
        this.actionReceiverPrefix = actionNamePrefix;
        this.emailReceivers.clear();
        this.smsReceivers.clear();
        this.appActionReceivers.clear();
        this.voiceReceivers.clear();
        this.runBookReceivers.clear();
        this.logicReceivers.clear();
        this.functionReceivers.clear();
        this.webhookReceivers.clear();
        this.itsmReceivers.clear();

        if (this.inner().emailReceivers() != null) {
            for (EmailReceiver er : this.inner().emailReceivers()) {
                this.emailReceivers.put(er.name(), er);
            }
        }

        if (this.inner().smsReceivers() != null) {
            for (SmsReceiver sr : this.inner().smsReceivers()) {
                this.smsReceivers.put(sr.name(), sr);
            }
        }


        if (this.inner().azureAppPushReceivers() != null) {
            for (AzureAppPushReceiver ar : this.inner().azureAppPushReceivers()) {
                this.appActionReceivers.put(ar.name(), ar);
            }
        }

        if (this.inner().voiceReceivers() != null) {
            for (VoiceReceiver vr : this.inner().voiceReceivers()) {
                this.voiceReceivers.put(vr.name(), vr);
            }
        }

        if (this.inner().automationRunbookReceivers() != null) {
            for (AutomationRunbookReceiver ar : this.inner().automationRunbookReceivers()) {
                this.runBookReceivers.put(ar.name(), ar);
            }
        }

        if (this.inner().logicAppReceivers() != null) {
            for (LogicAppReceiver lr : this.inner().logicAppReceivers()) {
                this.logicReceivers.put(lr.name(), lr);
            }
        }

        if (this.inner().azureFunctionReceivers() != null) {
            for (AzureFunctionReceiver fr : this.inner().azureFunctionReceivers()) {
                this.functionReceivers.put(fr.name(), fr);
            }
        }

        if (this.inner().webhookReceivers() != null) {
            for (WebhookReceiver wr : this.inner().webhookReceivers()) {
                this.webhookReceivers.put(wr.name(), wr);
            }
        }

        if (this.inner().itsmReceivers() != null) {
            for (ItsmReceiver ir : this.inner().itsmReceivers()) {
                this.itsmReceivers.put(ir.name(), ir);
            }
        }
        return this;
    }

    @Override
    public ActionGroupImpl withShortName(String shortName) {
        this.inner().withGroupShortName(shortName);
        return this;
    }

    @Override
    public Observable<ActionGroup> createResourceAsync() {
        this.inner().withLocation("global");
        return this.manager().inner().actionGroups().createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
                .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ActionGroupResourceInner> getInnerAsync() {
        return this.manager().inner().actionGroups().getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public ActionGroupImpl withEmail(String emailAddress) {
        this.withoutEmail();

        String compositeKey = this.actionReceiverPrefix + emailSuffix;
        EmailReceiver er = new EmailReceiver();
        er.withName(compositeKey);
        er.withEmailAddress(emailAddress);

        this.emailReceivers.put(compositeKey, er);
        return this;
    }

    @Override
    public ActionGroupImpl withSms(String countryCode, String phoneNumber) {
        this.withoutSms();

        String compositeKey = this.actionReceiverPrefix + smsSuffix;
        SmsReceiver sr = new SmsReceiver();
        sr.withName(compositeKey);
        sr.withCountryCode(countryCode);
        sr.withPhoneNumber(phoneNumber);

        this.smsReceivers.put(compositeKey, sr);
        return this;
    }

    @Override
    public ActionGroupImpl withWebhook(String serviceUri) {
        this.withoutWebhook();

        String compositeKey = this.actionReceiverPrefix + webhookSuffix;
        WebhookReceiver wr = new WebhookReceiver();
        wr.withName(compositeKey);
        wr.withServiceUri(serviceUri);

        this.webhookReceivers.put(compositeKey, wr);
        return this;
    }

    @Override
    public ActionGroupImpl withItsm(String workspaceId, String connectionId, String ticketConfiguration, String region) {
        this.withoutItsm();

        String compositeKey = this.actionReceiverPrefix + itsmSuffix;
        ItsmReceiver ir = new ItsmReceiver();
        ir.withName(compositeKey);
        ir.withWorkspaceId(workspaceId);
        ir.withConnectionId(connectionId);
        ir.withRegion(region);
        ir.withTicketConfiguration(ticketConfiguration);

        this.itsmReceivers.put(compositeKey, ir);
        return this;
    }

    @Override
    public ActionGroupImpl withAzureAppPush(String emailAddress) {
        this.withoutAzureAppPush();

        String compositeKey = this.actionReceiverPrefix + appActionSuffix;
        AzureAppPushReceiver ar = new AzureAppPushReceiver();
        ar.withName(compositeKey);
        ar.withEmailAddress(emailAddress);

        this.appActionReceivers.put(compositeKey, ar);
        return this;
    }

    @Override
    public ActionGroupImpl withAutomationRunbook(String automationAccountId, String runbookName, String webhookResourceId, boolean isGlobalRunbook) {
        this.withoutAutomationRunbook();

        String compositeKey = this.actionReceiverPrefix + runBookSuffix;
        AutomationRunbookReceiver arr = new AutomationRunbookReceiver();
        arr.withName(compositeKey);
        arr.withAutomationAccountId(automationAccountId);
        arr.withRunbookName(runbookName);
        arr.withWebhookResourceId(webhookResourceId);
        arr.withIsGlobalRunbook(isGlobalRunbook);

        this.runBookReceivers.put(compositeKey, arr);
        return this;
    }

    @Override
    public ActionGroupImpl withVoice(String countryCode, String phoneNumber) {
        this.withoutVoice();

        String compositeKey = this.actionReceiverPrefix + voiceSuffix;
        VoiceReceiver vr = new VoiceReceiver();
        vr.withName(compositeKey);
        vr.withCountryCode(countryCode);
        vr.withPhoneNumber(phoneNumber);

        this.voiceReceivers.put(compositeKey, vr);
        return this;
    }

    @Override
    public ActionGroupImpl withLogicApp(String logicAppResourceId, String callbackUrl) {
        this.withoutLogicApp();

        String compositeKey = this.actionReceiverPrefix + logicSuffix;
        LogicAppReceiver lr = new LogicAppReceiver();
        lr.withName(compositeKey);
        lr.withResourceId(logicAppResourceId);
        lr.withCallbackUrl(callbackUrl);

        this.logicReceivers.put(compositeKey, lr);
        return this;
    }

    @Override
    public ActionGroupImpl withAzureFunction(String functionAppResourceId, String functionName, String httpTriggerUrl) {
        this.withoutAzureFunction();
        String compositeKey = this.actionReceiverPrefix + functionSuffix;

        AzureFunctionReceiver afr = new AzureFunctionReceiver();
        afr.withName(compositeKey);
        afr.withFunctionAppResourceId(functionAppResourceId);
        afr.withFunctionName(functionName);
        afr.withHttpTriggerUrl(httpTriggerUrl);

        this.functionReceivers.put(compositeKey, afr);
        return this;
    }

    @Override
    public ActionGroupImpl attach() {
        this.actionReceiverPrefix = "";

        populateReceivers();

        this.emailReceivers.clear();
        this.smsReceivers.clear();
        this.appActionReceivers.clear();
        this.voiceReceivers.clear();
        this.runBookReceivers.clear();
        this.logicReceivers.clear();
        this.functionReceivers.clear();
        this.webhookReceivers.clear();
        this.itsmReceivers.clear();
        return this;
    }

    @Override
    public ActionGroupImpl withoutEmail() {
        String compositeKey = this.actionReceiverPrefix + emailSuffix;
        if (this.emailReceivers.containsKey(compositeKey)) {
            this.emailReceivers.remove(compositeKey);
        }
        if (this.emailReceivers.containsKey(this.actionReceiverPrefix)) {
            this.emailReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutSms() {
        String compositeKey = this.actionReceiverPrefix + smsSuffix;
        if (this.smsReceivers.containsKey(compositeKey)) {
            this.smsReceivers.remove(compositeKey);
        }
        if (this.smsReceivers.containsKey(this.actionReceiverPrefix)) {
            this.smsReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutWebhook() {
        String compositeKey = this.actionReceiverPrefix + webhookSuffix;
        if (this.webhookReceivers.containsKey(compositeKey)) {
            this.webhookReceivers.remove(compositeKey);
        }
        if (this.webhookReceivers.containsKey(this.actionReceiverPrefix)) {
            this.webhookReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutItsm() {
        String compositeKey = this.actionReceiverPrefix + itsmSuffix;
        if (this.itsmReceivers.containsKey(compositeKey)) {
            this.itsmReceivers.remove(compositeKey);
        }
        if (this.itsmReceivers.containsKey(this.actionReceiverPrefix)) {
            this.itsmReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutAzureAppPush() {
        String compositeKey = this.actionReceiverPrefix + appActionSuffix;
        if (this.appActionReceivers.containsKey(compositeKey)) {
            this.appActionReceivers.remove(compositeKey);
        }
        if (this.appActionReceivers.containsKey(this.actionReceiverPrefix)) {
            this.appActionReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutAutomationRunbook() {
        String compositeKey = this.actionReceiverPrefix + runBookSuffix;
        if (this.runBookReceivers.containsKey(compositeKey)) {
            this.runBookReceivers.remove(compositeKey);
        }
        if (this.runBookReceivers.containsKey(this.actionReceiverPrefix)) {
            this.runBookReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutVoice() {
        String compositeKey = this.actionReceiverPrefix + voiceSuffix;
        if (this.voiceReceivers.containsKey(compositeKey)) {
            this.voiceReceivers.remove(compositeKey);
        }
        if (this.voiceReceivers.containsKey(this.actionReceiverPrefix)) {
            this.voiceReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutLogicApp() {
        String compositeKey = this.actionReceiverPrefix + logicSuffix;
        if (this.logicReceivers.containsKey(compositeKey)) {
            this.logicReceivers.remove(compositeKey);
        }
        if (this.logicReceivers.containsKey(this.actionReceiverPrefix)) {
            this.logicReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl withoutAzureFunction() {
        String compositeKey = this.actionReceiverPrefix + logicSuffix;
        if (this.functionReceivers.containsKey(compositeKey)) {
            this.functionReceivers.remove(compositeKey);
        }
        if (this.functionReceivers.containsKey(this.actionReceiverPrefix)) {
            this.functionReceivers.remove(actionReceiverPrefix);
        }
        return this;
    }

    @Override
    public ActionGroupImpl parent() {
        return this.attach();
    }

    private void populateReceivers() {
        if (this.emailReceivers.values().size() > 0) {
            if (this.inner().emailReceivers() == null) {
                this.inner().withEmailReceivers(new ArrayList<EmailReceiver>());
            } else {
                this.inner().emailReceivers().clear();
            }
            this.inner().emailReceivers().addAll(this.emailReceivers.values());
        } else {
            this.inner().withEmailReceivers(null);
        }

        if (this.smsReceivers.values().size() > 0) {
            if (this.inner().smsReceivers() == null) {
                this.inner().withSmsReceivers(new ArrayList<SmsReceiver>());
            } else {
                this.inner().smsReceivers().clear();
            }
            this.inner().smsReceivers().addAll(this.smsReceivers.values());
        } else {
            this.inner().withSmsReceivers(null);
        }

        if (this.appActionReceivers.values().size() > 0) {
            if (this.inner().azureAppPushReceivers() == null) {
                this.inner().withAzureAppPushReceivers(new ArrayList<AzureAppPushReceiver>());
            } else {
                this.inner().azureAppPushReceivers().clear();
            }
            this.inner().azureAppPushReceivers().addAll(this.appActionReceivers.values());
        } else {
            this.inner().withAzureAppPushReceivers(null);
        }

        if (this.voiceReceivers.values().size() > 0) {
            if (this.inner().voiceReceivers() == null) {
                this.inner().withVoiceReceivers(new ArrayList<VoiceReceiver>());
            } else {
                this.inner().voiceReceivers().clear();
            }
            this.inner().voiceReceivers().addAll(this.voiceReceivers.values());
        } else {
            this.inner().withVoiceReceivers(null);
        }


        if (this.runBookReceivers.values().size() > 0) {
            if (this.inner().automationRunbookReceivers() == null) {
                this.inner().withAutomationRunbookReceivers(new ArrayList<AutomationRunbookReceiver>());
            } else {
                this.inner().automationRunbookReceivers().clear();
            }
            this.inner().automationRunbookReceivers().addAll(this.runBookReceivers.values());
        } else {
            this.inner().withAutomationRunbookReceivers(null);
        }

        if (this.logicReceivers.values().size() > 0) {
            if (this.inner().logicAppReceivers() == null) {
                this.inner().withLogicAppReceivers(new ArrayList<LogicAppReceiver>());
            } else {
                this.inner().logicAppReceivers().clear();
            }
            this.inner().logicAppReceivers().addAll(this.logicReceivers.values());
        } else {
            this.inner().withLogicAppReceivers(null);
        }

        if (this.functionReceivers.values().size() > 0) {
            if (this.inner().azureFunctionReceivers() == null) {
                this.inner().withAzureFunctionReceivers(new ArrayList<AzureFunctionReceiver>());
            } else {
                this.inner().azureFunctionReceivers().clear();
            }
            this.inner().azureFunctionReceivers().addAll(this.functionReceivers.values());
        } else {
            this.inner().withAzureFunctionReceivers(null);
        }

        if (this.webhookReceivers.values().size() > 0) {
            if (this.inner().webhookReceivers() == null) {
                this.inner().withWebhookReceivers(new ArrayList<WebhookReceiver>());
            } else {
                this.inner().webhookReceivers().clear();
            }
            this.inner().webhookReceivers().addAll(this.webhookReceivers.values());
        } else {
            this.inner().withWebhookReceivers(null);
        }

        if (this.itsmReceivers.values().size() > 0) {
            if (this.inner().itsmReceivers() == null) {
                this.inner().withItsmReceivers(new ArrayList<ItsmReceiver>());
            } else {
                this.inner().itsmReceivers().clear();
            }
            this.inner().itsmReceivers().addAll(this.itsmReceivers.values());
        } else {
            this.inner().withItsmReceivers(null);
        }

    }
}

