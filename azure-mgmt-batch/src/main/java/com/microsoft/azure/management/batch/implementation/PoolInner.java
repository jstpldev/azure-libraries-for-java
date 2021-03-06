/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.batch.implementation;

import org.joda.time.DateTime;
import com.microsoft.azure.management.batch.PoolProvisioningState;
import com.microsoft.azure.management.batch.AllocationState;
import com.microsoft.azure.management.batch.DeploymentConfiguration;
import com.microsoft.azure.management.batch.ScaleSettings;
import com.microsoft.azure.management.batch.AutoScaleRun;
import com.microsoft.azure.management.batch.InterNodeCommunicationState;
import com.microsoft.azure.management.batch.NetworkConfiguration;
import com.microsoft.azure.management.batch.TaskSchedulingPolicy;
import java.util.List;
import com.microsoft.azure.management.batch.UserAccount;
import com.microsoft.azure.management.batch.MetadataItem;
import com.microsoft.azure.management.batch.StartTask;
import com.microsoft.azure.management.batch.CertificateReference;
import com.microsoft.azure.management.batch.ApplicationPackageReference;
import com.microsoft.azure.management.batch.ResizeOperationStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * Contains information about a pool.
 */
@JsonFlatten
public class PoolInner extends ProxyResource {
    /**
     * The display name for the pool.
     * The display name need not be unique and can contain any Unicode
     * characters up to a maximum length of 1024.
     */
    @JsonProperty(value = "properties.displayName")
    private String displayName;

    /**
     * The last modified time of the pool.
     * This is the last time at which the pool level data, such as the
     * targetDedicatedNodes or autoScaleSettings, changed. It does not factor
     * in node-level changes such as a compute node changing state.
     */
    @JsonProperty(value = "properties.lastModified", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime lastModified;

    /**
     * The creation time of the pool.
     */
    @JsonProperty(value = "properties.creationTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime creationTime;

    /**
     * The current state of the pool.
     * Values are:
     *
     * Succeeded - The pool is available to run tasks subject to the
     * availability of compute nodes.
     * Deleting - The user has requested that the pool be deleted, but the
     * delete operation has not yet completed. Possible values include:
     * 'Succeeded', 'Deleting'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private PoolProvisioningState provisioningState;

    /**
     * The time at which the pool entered its current state.
     */
    @JsonProperty(value = "properties.provisioningStateTransitionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime provisioningStateTransitionTime;

    /**
     * Whether the pool is resizing.
     * Values are:
     *
     * Steady - The pool is not resizing. There are no changes to the number of
     * nodes in the pool in progress. A pool enters this state when it is
     * created and when no operations are being performed on the pool to change
     * the number of dedicated nodes.
     * Resizing - The pool is resizing; that is, compute nodes are being added
     * to or removed from the pool.
     * Stopping - The pool was resizing, but the user has requested that the
     * resize be stopped, but the stop request has not yet been completed.
     * Possible values include: 'Steady', 'Resizing', 'Stopping'.
     */
    @JsonProperty(value = "properties.allocationState", access = JsonProperty.Access.WRITE_ONLY)
    private AllocationState allocationState;

    /**
     * The time at which the pool entered its current allocation state.
     */
    @JsonProperty(value = "properties.allocationStateTransitionTime", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime allocationStateTransitionTime;

    /**
     * The size of virtual machines in the pool. All VMs in a pool are the same
     * size.
     * For information about available sizes of virtual machines for Cloud
     * Services pools (pools created with cloudServiceConfiguration), see Sizes
     * for Cloud Services
     * (http://azure.microsoft.com/documentation/articles/cloud-services-sizes-specs/).
     * Batch supports all Cloud Services VM sizes except ExtraSmall. For
     * information about available VM sizes for pools using images from the
     * Virtual Machines Marketplace (pools created with
     * virtualMachineConfiguration) see Sizes for Virtual Machines (Linux)
     * (https://azure.microsoft.com/documentation/articles/virtual-machines-linux-sizes/)
     * or Sizes for Virtual Machines (Windows)
     * (https://azure.microsoft.com/documentation/articles/virtual-machines-windows-sizes/).
     * Batch supports all Azure VM sizes except STANDARD_A0 and those with
     * premium storage (STANDARD_GS, STANDARD_DS, and STANDARD_DSV2 series).
     */
    @JsonProperty(value = "properties.vmSize")
    private String vmSize;

    /**
     * This property describes how the pool nodes will be deployed - using
     * Cloud Services or Virtual Machines.
     * Using CloudServiceConfiguration specifies that the nodes should be
     * creating using Azure Cloud Services (PaaS), while
     * VirtualMachineConfiguration uses Azure Virtual Machines (IaaS).
     */
    @JsonProperty(value = "properties.deploymentConfiguration")
    private DeploymentConfiguration deploymentConfiguration;

    /**
     * The number of compute nodes currently in the pool.
     */
    @JsonProperty(value = "properties.currentDedicatedNodes", access = JsonProperty.Access.WRITE_ONLY)
    private Integer currentDedicatedNodes;

    /**
     * The number of low priority compute nodes currently in the pool.
     */
    @JsonProperty(value = "properties.currentLowPriorityNodes", access = JsonProperty.Access.WRITE_ONLY)
    private Integer currentLowPriorityNodes;

    /**
     * Settings which configure the number of nodes in the pool.
     */
    @JsonProperty(value = "properties.scaleSettings")
    private ScaleSettings scaleSettings;

    /**
     * The results and errors from the last execution of the autoscale formula.
     * This property is set only if the pool automatically scales, i.e.
     * autoScaleSettings are used.
     */
    @JsonProperty(value = "properties.autoScaleRun", access = JsonProperty.Access.WRITE_ONLY)
    private AutoScaleRun autoScaleRun;

    /**
     * Whether the pool permits direct communication between nodes.
     * This imposes restrictions on which nodes can be assigned to the pool.
     * Enabling this value can reduce the chance of the requested number of
     * nodes to be allocated in the pool. If not specified, this value defaults
     * to 'Disabled'. Possible values include: 'Enabled', 'Disabled'.
     */
    @JsonProperty(value = "properties.interNodeCommunication")
    private InterNodeCommunicationState interNodeCommunication;

    /**
     * The network configuration for the pool.
     */
    @JsonProperty(value = "properties.networkConfiguration")
    private NetworkConfiguration networkConfiguration;

    /**
     * The maximum number of tasks that can run concurrently on a single
     * compute node in the pool.
     */
    @JsonProperty(value = "properties.maxTasksPerNode")
    private Integer maxTasksPerNode;

    /**
     * How tasks are distributed across compute nodes in a pool.
     */
    @JsonProperty(value = "properties.taskSchedulingPolicy")
    private TaskSchedulingPolicy taskSchedulingPolicy;

    /**
     * The list of user accounts to be created on each node in the pool.
     */
    @JsonProperty(value = "properties.userAccounts")
    private List<UserAccount> userAccounts;

    /**
     * A list of name-value pairs associated with the pool as metadata.
     * The Batch service does not assign any meaning to metadata; it is solely
     * for the use of user code.
     */
    @JsonProperty(value = "properties.metadata")
    private List<MetadataItem> metadata;

    /**
     * A task specified to run on each compute node as it joins the pool.
     * In an PATCH (update) operation, this property can be set to an empty
     * object to remove the start task from the pool.
     */
    @JsonProperty(value = "properties.startTask")
    private StartTask startTask;

    /**
     * The list of certificates to be installed on each compute node in the
     * pool.
     * For Windows compute nodes, the Batch service installs the certificates
     * to the specified certificate store and location. For Linux compute
     * nodes, the certificates are stored in a directory inside the task
     * working directory and an environment variable AZ_BATCH_CERTIFICATES_DIR
     * is supplied to the task to query for this location. For certificates
     * with visibility of 'remoteUser', a 'certs' directory is created in the
     * user's home directory (e.g., /home/{user-name}/certs) and certificates
     * are placed in that directory.
     */
    @JsonProperty(value = "properties.certificates")
    private List<CertificateReference> certificates;

    /**
     * The list of application packages to be installed on each compute node in
     * the pool.
     * Changes to application packages affect all new compute nodes joining the
     * pool, but do not affect compute nodes that are already in the pool until
     * they are rebooted or reimaged.
     */
    @JsonProperty(value = "properties.applicationPackages")
    private List<ApplicationPackageReference> applicationPackages;

    /**
     * The list of application licenses the Batch service will make available
     * on each compute node in the pool.
     * The list of application licenses must be a subset of available Batch
     * service application licenses. If a license is requested which is not
     * supported, pool creation will fail.
     */
    @JsonProperty(value = "properties.applicationLicenses")
    private List<String> applicationLicenses;

    /**
     * Contains details about the current or last completed resize operation.
     */
    @JsonProperty(value = "properties.resizeOperationStatus", access = JsonProperty.Access.WRITE_ONLY)
    private ResizeOperationStatus resizeOperationStatus;

    /**
     * The ETag of the resource, used for concurrency statements.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Get the displayName value.
     *
     * @return the displayName value
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName value.
     *
     * @param displayName the displayName value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the lastModified value.
     *
     * @return the lastModified value
     */
    public DateTime lastModified() {
        return this.lastModified;
    }

    /**
     * Get the creationTime value.
     *
     * @return the creationTime value
     */
    public DateTime creationTime() {
        return this.creationTime;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public PoolProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the provisioningStateTransitionTime value.
     *
     * @return the provisioningStateTransitionTime value
     */
    public DateTime provisioningStateTransitionTime() {
        return this.provisioningStateTransitionTime;
    }

    /**
     * Get the allocationState value.
     *
     * @return the allocationState value
     */
    public AllocationState allocationState() {
        return this.allocationState;
    }

    /**
     * Get the allocationStateTransitionTime value.
     *
     * @return the allocationStateTransitionTime value
     */
    public DateTime allocationStateTransitionTime() {
        return this.allocationStateTransitionTime;
    }

    /**
     * Get the vmSize value.
     *
     * @return the vmSize value
     */
    public String vmSize() {
        return this.vmSize;
    }

    /**
     * Set the vmSize value.
     *
     * @param vmSize the vmSize value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withVmSize(String vmSize) {
        this.vmSize = vmSize;
        return this;
    }

    /**
     * Get the deploymentConfiguration value.
     *
     * @return the deploymentConfiguration value
     */
    public DeploymentConfiguration deploymentConfiguration() {
        return this.deploymentConfiguration;
    }

    /**
     * Set the deploymentConfiguration value.
     *
     * @param deploymentConfiguration the deploymentConfiguration value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withDeploymentConfiguration(DeploymentConfiguration deploymentConfiguration) {
        this.deploymentConfiguration = deploymentConfiguration;
        return this;
    }

    /**
     * Get the currentDedicatedNodes value.
     *
     * @return the currentDedicatedNodes value
     */
    public Integer currentDedicatedNodes() {
        return this.currentDedicatedNodes;
    }

    /**
     * Get the currentLowPriorityNodes value.
     *
     * @return the currentLowPriorityNodes value
     */
    public Integer currentLowPriorityNodes() {
        return this.currentLowPriorityNodes;
    }

    /**
     * Get the scaleSettings value.
     *
     * @return the scaleSettings value
     */
    public ScaleSettings scaleSettings() {
        return this.scaleSettings;
    }

    /**
     * Set the scaleSettings value.
     *
     * @param scaleSettings the scaleSettings value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withScaleSettings(ScaleSettings scaleSettings) {
        this.scaleSettings = scaleSettings;
        return this;
    }

    /**
     * Get the autoScaleRun value.
     *
     * @return the autoScaleRun value
     */
    public AutoScaleRun autoScaleRun() {
        return this.autoScaleRun;
    }

    /**
     * Get the interNodeCommunication value.
     *
     * @return the interNodeCommunication value
     */
    public InterNodeCommunicationState interNodeCommunication() {
        return this.interNodeCommunication;
    }

    /**
     * Set the interNodeCommunication value.
     *
     * @param interNodeCommunication the interNodeCommunication value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withInterNodeCommunication(InterNodeCommunicationState interNodeCommunication) {
        this.interNodeCommunication = interNodeCommunication;
        return this;
    }

    /**
     * Get the networkConfiguration value.
     *
     * @return the networkConfiguration value
     */
    public NetworkConfiguration networkConfiguration() {
        return this.networkConfiguration;
    }

    /**
     * Set the networkConfiguration value.
     *
     * @param networkConfiguration the networkConfiguration value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withNetworkConfiguration(NetworkConfiguration networkConfiguration) {
        this.networkConfiguration = networkConfiguration;
        return this;
    }

    /**
     * Get the maxTasksPerNode value.
     *
     * @return the maxTasksPerNode value
     */
    public Integer maxTasksPerNode() {
        return this.maxTasksPerNode;
    }

    /**
     * Set the maxTasksPerNode value.
     *
     * @param maxTasksPerNode the maxTasksPerNode value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withMaxTasksPerNode(Integer maxTasksPerNode) {
        this.maxTasksPerNode = maxTasksPerNode;
        return this;
    }

    /**
     * Get the taskSchedulingPolicy value.
     *
     * @return the taskSchedulingPolicy value
     */
    public TaskSchedulingPolicy taskSchedulingPolicy() {
        return this.taskSchedulingPolicy;
    }

    /**
     * Set the taskSchedulingPolicy value.
     *
     * @param taskSchedulingPolicy the taskSchedulingPolicy value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withTaskSchedulingPolicy(TaskSchedulingPolicy taskSchedulingPolicy) {
        this.taskSchedulingPolicy = taskSchedulingPolicy;
        return this;
    }

    /**
     * Get the userAccounts value.
     *
     * @return the userAccounts value
     */
    public List<UserAccount> userAccounts() {
        return this.userAccounts;
    }

    /**
     * Set the userAccounts value.
     *
     * @param userAccounts the userAccounts value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withUserAccounts(List<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
        return this;
    }

    /**
     * Get the metadata value.
     *
     * @return the metadata value
     */
    public List<MetadataItem> metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata value.
     *
     * @param metadata the metadata value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withMetadata(List<MetadataItem> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the startTask value.
     *
     * @return the startTask value
     */
    public StartTask startTask() {
        return this.startTask;
    }

    /**
     * Set the startTask value.
     *
     * @param startTask the startTask value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withStartTask(StartTask startTask) {
        this.startTask = startTask;
        return this;
    }

    /**
     * Get the certificates value.
     *
     * @return the certificates value
     */
    public List<CertificateReference> certificates() {
        return this.certificates;
    }

    /**
     * Set the certificates value.
     *
     * @param certificates the certificates value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withCertificates(List<CertificateReference> certificates) {
        this.certificates = certificates;
        return this;
    }

    /**
     * Get the applicationPackages value.
     *
     * @return the applicationPackages value
     */
    public List<ApplicationPackageReference> applicationPackages() {
        return this.applicationPackages;
    }

    /**
     * Set the applicationPackages value.
     *
     * @param applicationPackages the applicationPackages value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withApplicationPackages(List<ApplicationPackageReference> applicationPackages) {
        this.applicationPackages = applicationPackages;
        return this;
    }

    /**
     * Get the applicationLicenses value.
     *
     * @return the applicationLicenses value
     */
    public List<String> applicationLicenses() {
        return this.applicationLicenses;
    }

    /**
     * Set the applicationLicenses value.
     *
     * @param applicationLicenses the applicationLicenses value to set
     * @return the PoolInner object itself.
     */
    public PoolInner withApplicationLicenses(List<String> applicationLicenses) {
        this.applicationLicenses = applicationLicenses;
        return this;
    }

    /**
     * Get the resizeOperationStatus value.
     *
     * @return the resizeOperationStatus value
     */
    public ResizeOperationStatus resizeOperationStatus() {
        return this.resizeOperationStatus;
    }

    /**
     * Get the etag value.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

}
