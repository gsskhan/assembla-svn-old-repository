/**
 * 
 */
package com.citi.ets.dashboard.bean;

/**
 * @author ak64503
 *
 */
public class ColumnDetails {
    
    private Component overall;
    private Component infrastructure;
    private Component batch;
    private Component feedsIn;
    private Component feedsOut;
    private Component dailyProcessing;    
    private Component monthlyProcessing;
    /**
     * @return the overall
     */
    public Component getOverall() {
        return overall;
    }
    /**
     * @param overall the overall to set
     */
    public void setOverall(Component overall) {
        this.overall = overall;
    }
    /**
     * @return the infrastructure
     */
    public Component getInfrastructure() {
        return infrastructure;
    }
    /**
     * @param infrastructure the infrastructure to set
     */
    public void setInfrastructure(Component infrastructure) {
        this.infrastructure = infrastructure;
    }
    /**
     * @return the batch
     */
    public Component getBatch() {
        return batch;
    }
    /**
     * @param batch the batch to set
     */
    public void setBatch(Component batch) {
        this.batch = batch;
    }
    /**
     * @return the feedIn
     */
    public Component getFeedsIn() {
        return feedsIn;
    }
    /**
     * @param feedIn the feedIn to set
     */
    public void setFeedsIn(Component feedsIn) {
        this.feedsIn = feedsIn;
    }
    /**
     * @return the feedOut
     */
    public Component getFeedsOut() {
        return feedsOut;
    }
    /**
     * @param feedOut the feedOut to set
     */
    public void setFeedsOut(Component feedsOut) {
        this.feedsOut = feedsOut;
    }
    /**
     * @return the dailyProcessing
     */
    public Component getDailyProcessing() {
        return dailyProcessing;
    }
    /**
     * @param dailyProcessing the dailyProcessing to set
     */
    public void setDailyProcessing(Component dailyProcessing) {
        this.dailyProcessing = dailyProcessing;
    }
    /**
     * @return the monthlyProcessing
     */
    public Component getMonthlyProcessing() {
        return monthlyProcessing;
    }
    /**
     * @param monthlyProcessing the monthlyProcessing to set
     */
    public void setMonthlyProcessing(Component monthlyProcessing) {
        this.monthlyProcessing = monthlyProcessing;
    }
   
    
}
