/**
 * 
 */
package com.citi.ets.dashboard.bean;

import java.util.List;

/**
 * @author ak64503
 *
 */
public class Bean {
	private String appname;
	private String overall;
	private String infra;
	private String feedsIn;
	private String feedsOut;
			
	private List<Bean> children;

	/**
	 * @return the appname
	 */
	public String getAppname() {
		return appname;
	}

	/**
	 * @param appname the appname to set
	 */
	public void setAppname(String appname) {
		this.appname = appname;
	}

	/**
	 * @return the overall
	 */
	public String getOverall() {
		return overall;
	}

	/**
	 * @param overall the overall to set
	 */
	public void setOverall(String overall) {
		this.overall = overall;
	}

	/**
	 * @return the infra
	 */
	public String getInfra() {
		return infra;
	}

	/**
	 * @param infra the infra to set
	 */
	public void setInfra(String infra) {
		this.infra = infra;
	}

	/**
	 * @return the feedsIn
	 */
	public String getFeedsIn() {
		return feedsIn;
	}

	/**
	 * @param feedsIn the feedsIn to set
	 */
	public void setFeedsIn(String feedsIn) {
		this.feedsIn = feedsIn;
	}

	/**
	 * @return the feedsOut
	 */
	public String getFeedsOut() {
		return feedsOut;
	}

	/**
	 * @param feedsOut the feedsOut to set
	 */
	public void setFeedsOut(String feedsOut) {
		this.feedsOut = feedsOut;
	}

	/**
	 * @return the children
	 */
	public List<Bean> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Bean> children) {
		this.children = children;
	}

	
	
}
