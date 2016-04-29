create or replace
TYPE ORC_ACCT_LVL_EXCP_TYP
AS
  OBJECT
  (
    attr_nm        VARCHAR2(32),
    error_typ      VARCHAR2(20), 
    root_exception VARCHAR2(200)
    );

create or replace
type ORC_ACCT_LVL_EXCP_TYP_ARRAY 
as table of ORC_ACCT_LVL_EXCP_TYP;