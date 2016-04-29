/**
 * 
 */
package com.citi.retail.optima.etl.validation.model;

import java.util.Date;

/**
 * @author TJ
 *
 */
public class PooledDataModel {

	private Boolean success;
	private Integer d_os_acct_ge30_dpd_24m;
	private Integer n_accts_ge30_dpd_24m;
	private Integer d_acct_ever_30dpd_last12;
	private Integer d_acct_ever_60dpd_last12;
	private Integer n_new_accounts;
	private Integer d_new_accounts;
	private Integer d_commitments;
	private Integer d_new_commitments;
	private Integer d_commitment_increases;
	private Integer d_commitment_decreases;
	private Integer d_modifications;
	private Integer d_gross_contractual_co;
	private Integer d_bankruptcy_co;
	private Integer d_recoveries;
	private Integer n_acct_co;
	private Integer d_net_co;
	private Integer d_adj_net_co;
	private Integer d_foreclosure;
	private Integer d_new_foreclosure;
	private Integer d_reo;
	private Integer d_new_reo;
	private Integer d_vehicle_type_car_van;
	private Integer d_vehicle_type_suv_truck;
	private Integer d_vehicle_type_sport;
	private Integer d_vehicle_type_unknown;
	private Integer d_repo;
	private Integer d_cur_month_repo;
	private Integer d_proj_value_lease;
	private Integer d_act_sale_proceeds_lease;
	private Integer ref_portfolio_ccy;
	private Integer ref_fx_rate;
	private Integer ref_reporting_basis;
	private Date reporting_period;
	private String gcbc_portfolio_id;
	private String submitter_id;
	private String contact_id;
	private String version;
	private String region;
	private String country;
	private String productType;
	private Integer collateralized_flg;
	private Integer curr_line_loan_size;
	private Integer orig_ltv;
	private Integer age;
	private Integer vintage;
	private Integer curr_dlq_status;
	private Integer orig_fico;
	private Integer n_acct;
	private Integer d_upb;
	private Integer d_enr;
	/**
	 * @return the d_os_acct_ge30_dpd_24m
	 */
	public Integer getD_os_acct_ge30_dpd_24m() {
		return d_os_acct_ge30_dpd_24m;
	}
	/**
	 * @param d_os_acct_ge30_dpd_24m the d_os_acct_ge30_dpd_24m to set
	 */
	public void setD_os_acct_ge30_dpd_24m(Integer d_os_acct_ge30_dpd_24m) {
		this.d_os_acct_ge30_dpd_24m = d_os_acct_ge30_dpd_24m;
	}
	/**
	 * @return the n_accts_ge30_dpd_24m
	 */
	public Integer getN_accts_ge30_dpd_24m() {
		return n_accts_ge30_dpd_24m;
	}
	/**
	 * @param n_accts_ge30_dpd_24m the n_accts_ge30_dpd_24m to set
	 */
	public void setN_accts_ge30_dpd_24m(Integer n_accts_ge30_dpd_24m) {
		this.n_accts_ge30_dpd_24m = n_accts_ge30_dpd_24m;
	}
	/**
	 * @return the d_acct_ever_30dpd_last12
	 */
	public Integer getD_acct_ever_30dpd_last12() {
		return d_acct_ever_30dpd_last12;
	}
	/**
	 * @param d_acct_ever_30dpd_last12 the d_acct_ever_30dpd_last12 to set
	 */
	public void setD_acct_ever_30dpd_last12(Integer d_acct_ever_30dpd_last12) {
		this.d_acct_ever_30dpd_last12 = d_acct_ever_30dpd_last12;
	}
	/**
	 * @return the d_acct_ever_60dpd_last12
	 */
	public Integer getD_acct_ever_60dpd_last12() {
		return d_acct_ever_60dpd_last12;
	}
	/**
	 * @param d_acct_ever_60dpd_last12 the d_acct_ever_60dpd_last12 to set
	 */
	public void setD_acct_ever_60dpd_last12(Integer d_acct_ever_60dpd_last12) {
		this.d_acct_ever_60dpd_last12 = d_acct_ever_60dpd_last12;
	}
	/**
	 * @return the n_new_accounts
	 */
	public Integer getN_new_accounts() {
		return n_new_accounts;
	}
	/**
	 * @param n_new_accounts the n_new_accounts to set
	 */
	public void setN_new_accounts(Integer n_new_accounts) {
		this.n_new_accounts = n_new_accounts;
	}
	/**
	 * @return the d_new_accounts
	 */
	public Integer getD_new_accounts() {
		return d_new_accounts;
	}
	/**
	 * @param d_new_accounts the d_new_accounts to set
	 */
	public void setD_new_accounts(Integer d_new_accounts) {
		this.d_new_accounts = d_new_accounts;
	}
	/**
	 * @return the d_commitments
	 */
	public Integer getD_commitments() {
		return d_commitments;
	}
	/**
	 * @param d_commitments the d_commitments to set
	 */
	public void setD_commitments(Integer d_commitments) {
		this.d_commitments = d_commitments;
	}
	/**
	 * @return the d_new_commitments
	 */
	public Integer getD_new_commitments() {
		return d_new_commitments;
	}
	/**
	 * @param d_new_commitments the d_new_commitments to set
	 */
	public void setD_new_commitments(Integer d_new_commitments) {
		this.d_new_commitments = d_new_commitments;
	}
	/**
	 * @return the d_commitment_increases
	 */
	public Integer getD_commitment_increases() {
		return d_commitment_increases;
	}
	/**
	 * @param d_commitment_increases the d_commitment_increases to set
	 */
	public void setD_commitment_increases(Integer d_commitment_increases) {
		this.d_commitment_increases = d_commitment_increases;
	}
	/**
	 * @return the d_commitment_decreases
	 */
	public Integer getD_commitment_decreases() {
		return d_commitment_decreases;
	}
	/**
	 * @param d_commitment_decreases the d_commitment_decreases to set
	 */
	public void setD_commitment_decreases(Integer d_commitment_decreases) {
		this.d_commitment_decreases = d_commitment_decreases;
	}
	/**
	 * @return the d_modifications
	 */
	public Integer getD_modifications() {
		return d_modifications;
	}
	/**
	 * @param d_modifications the d_modifications to set
	 */
	public void setD_modifications(Integer d_modifications) {
		this.d_modifications = d_modifications;
	}
	/**
	 * @return the d_gross_contractual_co
	 */
	public Integer getD_gross_contractual_co() {
		return d_gross_contractual_co;
	}
	/**
	 * @param d_gross_contractual_co the d_gross_contractual_co to set
	 */
	public void setD_gross_contractual_co(Integer d_gross_contractual_co) {
		this.d_gross_contractual_co = d_gross_contractual_co;
	}
	/**
	 * @return the d_bankruptcy_co
	 */
	public Integer getD_bankruptcy_co() {
		return d_bankruptcy_co;
	}
	/**
	 * @param d_bankruptcy_co the d_bankruptcy_co to set
	 */
	public void setD_bankruptcy_co(Integer d_bankruptcy_co) {
		this.d_bankruptcy_co = d_bankruptcy_co;
	}
	/**
	 * @return the d_recoveries
	 */
	public Integer getD_recoveries() {
		return d_recoveries;
	}
	/**
	 * @param d_recoveries the d_recoveries to set
	 */
	public void setD_recoveries(Integer d_recoveries) {
		this.d_recoveries = d_recoveries;
	}
	/**
	 * @return the n_acct_co
	 */
	public Integer getN_acct_co() {
		return n_acct_co;
	}
	/**
	 * @param n_acct_co the n_acct_co to set
	 */
	public void setN_acct_co(Integer n_acct_co) {
		this.n_acct_co = n_acct_co;
	}
	/**
	 * @return the d_net_co
	 */
	public Integer getD_net_co() {
		return d_net_co;
	}
	/**
	 * @param d_net_co the d_net_co to set
	 */
	public void setD_net_co(Integer d_net_co) {
		this.d_net_co = d_net_co;
	}
	/**
	 * @return the d_adj_net_co
	 */
	public Integer getD_adj_net_co() {
		return d_adj_net_co;
	}
	/**
	 * @param d_adj_net_co the d_adj_net_co to set
	 */
	public void setD_adj_net_co(Integer d_adj_net_co) {
		this.d_adj_net_co = d_adj_net_co;
	}
	/**
	 * @return the d_foreclosure
	 */
	public Integer getD_foreclosure() {
		return d_foreclosure;
	}
	/**
	 * @param d_foreclosure the d_foreclosure to set
	 */
	public void setD_foreclosure(Integer d_foreclosure) {
		this.d_foreclosure = d_foreclosure;
	}
	/**
	 * @return the d_new_foreclosure
	 */
	public Integer getD_new_foreclosure() {
		return d_new_foreclosure;
	}
	/**
	 * @param d_new_foreclosure the d_new_foreclosure to set
	 */
	public void setD_new_foreclosure(Integer d_new_foreclosure) {
		this.d_new_foreclosure = d_new_foreclosure;
	}
	/**
	 * @return the d_reo
	 */
	public Integer getD_reo() {
		return d_reo;
	}
	/**
	 * @param d_reo the d_reo to set
	 */
	public void setD_reo(Integer d_reo) {
		this.d_reo = d_reo;
	}
	/**
	 * @return the d_new_reo
	 */
	public Integer getD_new_reo() {
		return d_new_reo;
	}
	/**
	 * @param d_new_reo the d_new_reo to set
	 */
	public void setD_new_reo(Integer d_new_reo) {
		this.d_new_reo = d_new_reo;
	}
	/**
	 * @return the d_vehicle_type_car_van
	 */
	public Integer getD_vehicle_type_car_van() {
		return d_vehicle_type_car_van;
	}
	/**
	 * @param d_vehicle_type_car_van the d_vehicle_type_car_van to set
	 */
	public void setD_vehicle_type_car_van(Integer d_vehicle_type_car_van) {
		this.d_vehicle_type_car_van = d_vehicle_type_car_van;
	}
	/**
	 * @return the d_vehicle_type_suv_truck
	 */
	public Integer getD_vehicle_type_suv_truck() {
		return d_vehicle_type_suv_truck;
	}
	/**
	 * @param d_vehicle_type_suv_truck the d_vehicle_type_suv_truck to set
	 */
	public void setD_vehicle_type_suv_truck(Integer d_vehicle_type_suv_truck) {
		this.d_vehicle_type_suv_truck = d_vehicle_type_suv_truck;
	}
	/**
	 * @return the d_vehicle_type_sport
	 */
	public Integer getD_vehicle_type_sport() {
		return d_vehicle_type_sport;
	}
	/**
	 * @param d_vehicle_type_sport the d_vehicle_type_sport to set
	 */
	public void setD_vehicle_type_sport(Integer d_vehicle_type_sport) {
		this.d_vehicle_type_sport = d_vehicle_type_sport;
	}
	/**
	 * @return the d_vehicle_type_unknown
	 */
	public Integer getD_vehicle_type_unknown() {
		return d_vehicle_type_unknown;
	}
	/**
	 * @param d_vehicle_type_unknown the d_vehicle_type_unknown to set
	 */
	public void setD_vehicle_type_unknown(Integer d_vehicle_type_unknown) {
		this.d_vehicle_type_unknown = d_vehicle_type_unknown;
	}
	/**
	 * @return the d_repo
	 */
	public Integer getD_repo() {
		return d_repo;
	}
	/**
	 * @param d_repo the d_repo to set
	 */
	public void setD_repo(Integer d_repo) {
		this.d_repo = d_repo;
	}
	/**
	 * @return the d_cur_month_repo
	 */
	public Integer getD_cur_month_repo() {
		return d_cur_month_repo;
	}
	/**
	 * @param d_cur_month_repo the d_cur_month_repo to set
	 */
	public void setD_cur_month_repo(Integer d_cur_month_repo) {
		this.d_cur_month_repo = d_cur_month_repo;
	}
	/**
	 * @return the d_proj_value_lease
	 */
	public Integer getD_proj_value_lease() {
		return d_proj_value_lease;
	}
	/**
	 * @param d_proj_value_lease the d_proj_value_lease to set
	 */
	public void setD_proj_value_lease(Integer d_proj_value_lease) {
		this.d_proj_value_lease = d_proj_value_lease;
	}
	/**
	 * @return the d_act_sale_proceeds_lease
	 */
	public Integer getD_act_sale_proceeds_lease() {
		return d_act_sale_proceeds_lease;
	}
	/**
	 * @param d_act_sale_proceeds_lease the d_act_sale_proceeds_lease to set
	 */
	public void setD_act_sale_proceeds_lease(Integer d_act_sale_proceeds_lease) {
		this.d_act_sale_proceeds_lease = d_act_sale_proceeds_lease;
	}
	/**
	 * @return the ref_portfolio_ccy
	 */
	public Integer getRef_portfolio_ccy() {
		return ref_portfolio_ccy;
	}
	/**
	 * @param ref_portfolio_ccy the ref_portfolio_ccy to set
	 */
	public void setRef_portfolio_ccy(Integer ref_portfolio_ccy) {
		this.ref_portfolio_ccy = ref_portfolio_ccy;
	}
	/**
	 * @return the ref_fx_rate
	 */
	public Integer getRef_fx_rate() {
		return ref_fx_rate;
	}
	/**
	 * @param ref_fx_rate the ref_fx_rate to set
	 */
	public void setRef_fx_rate(Integer ref_fx_rate) {
		this.ref_fx_rate = ref_fx_rate;
	}
	/**
	 * @return the ref_reporting_basis
	 */
	public Integer getRef_reporting_basis() {
		return ref_reporting_basis;
	}
	/**
	 * @param ref_reporting_basis the ref_reporting_basis to set
	 */
	public void setRef_reporting_basis(Integer ref_reporting_basis) {
		this.ref_reporting_basis = ref_reporting_basis;
	}
	/**
	 * @return the reporting_period
	 */
	public Date getReporting_period() {
		return reporting_period;
	}
	/**
	 * @param reporting_period the reporting_period to set
	 */
	public void setReporting_period(Date reporting_period) {
		this.reporting_period = reporting_period;
	}
	/**
	 * @return the gcbc_portfolio_id
	 */
	public String getGcbc_portfolio_id() {
		return gcbc_portfolio_id;
	}
	/**
	 * @param gcbc_portfolio_id the gcbc_portfolio_id to set
	 */
	public void setGcbc_portfolio_id(String gcbc_portfolio_id) {
		this.gcbc_portfolio_id = gcbc_portfolio_id;
	}
	/**
	 * @return the submitter_id
	 */
	public String getSubmitter_id() {
		return submitter_id;
	}
	/**
	 * @param submitter_id the submitter_id to set
	 */
	public void setSubmitter_id(String submitter_id) {
		this.submitter_id = submitter_id;
	}
	/**
	 * @return the contact_id
	 */
	public String getContact_id() {
		return contact_id;
	}
	/**
	 * @param contact_id the contact_id to set
	 */
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the product_type
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * @param product_type the product_type to set
	 */
	public void setProductType(String product_type) {
		this.productType = product_type;
	}
	/**
	 * @return the collateralized_flg
	 */
	public Integer getCollateralized_flg() {
		return collateralized_flg;
	}
	/**
	 * @param collateralized_flg the collateralized_flg to set
	 */
	public void setCollateralized_flg(Integer collateralized_flg) {
		this.collateralized_flg = collateralized_flg;
	}
	/**
	 * @return the curr_line_loan_size
	 */
	public Integer getCurr_line_loan_size() {
		return curr_line_loan_size;
	}
	/**
	 * @param curr_line_loan_size the curr_line_loan_size to set
	 */
	public void setCurr_line_loan_size(Integer curr_line_loan_size) {
		this.curr_line_loan_size = curr_line_loan_size;
	}
	/**
	 * @return the orig_ltv
	 */
	public Integer getOrig_ltv() {
		return orig_ltv;
	}
	/**
	 * @param orig_ltv the orig_ltv to set
	 */
	public void setOrig_ltv(Integer orig_ltv) {
		this.orig_ltv = orig_ltv;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the vintage
	 */
	public Integer getVintage() {
		return vintage;
	}
	/**
	 * @param vintage the vintage to set
	 */
	public void setVintage(Integer vintage) {
		this.vintage = vintage;
	}
	/**
	 * @return the curr_dlq_status
	 */
	public Integer getCurr_dlq_status() {
		return curr_dlq_status;
	}
	/**
	 * @param curr_dlq_status the curr_dlq_status to set
	 */
	public void setCurr_dlq_status(Integer curr_dlq_status) {
		this.curr_dlq_status = curr_dlq_status;
	}
	/**
	 * @return the orig_fico
	 */
	public Integer getOrig_fico() {
		return orig_fico;
	}
	/**
	 * @param orig_fico the orig_fico to set
	 */
	public void setOrig_fico(Integer orig_fico) {
		this.orig_fico = orig_fico;
	}
	/**
	 * @return the n_acct
	 */
	public Integer getN_acct() {
		return n_acct;
	}
	/**
	 * @param n_acct the n_acct to set
	 */
	public void setN_acct(Integer n_acct) {
		this.n_acct = n_acct;
	}
	/**
	 * @return the d_upb
	 */
	public Integer getD_upb() {
		return d_upb;
	}
	/**
	 * @param d_upb the d_upb to set
	 */
	public void setD_upb(Integer d_upb) {
		this.d_upb = d_upb;
	}
	/**
	 * @return the d_enr
	 */
	public Integer getD_enr() {
		return d_enr;
	}
	/**
	 * @param d_enr the d_enr to set
	 */
	public void setD_enr(Integer d_enr) {
		this.d_enr = d_enr;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}	

}
