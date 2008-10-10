--------------------------------------------------------
--  File created - Wednesday-September-24-2008   
--------------------------------------------------------
  DROP TABLE "JBPM_ACTION" cascade constraints;
  DROP TABLE "JBPM_BYTEARRAY" cascade constraints;
  DROP TABLE "JBPM_BYTEBLOCK" cascade constraints;
  DROP TABLE "JBPM_COMMENT" cascade constraints;
  DROP TABLE "JBPM_DECISIONCONDITIONS" cascade constraints;
  DROP TABLE "JBPM_DELEGATION" cascade constraints;
  DROP TABLE "JBPM_EVENT" cascade constraints;
  DROP TABLE "JBPM_EXCEPTIONHANDLER" cascade constraints;
  DROP TABLE "JBPM_ID_GROUP" cascade constraints;
  DROP TABLE "JBPM_ID_MEMBERSHIP" cascade constraints;
  DROP TABLE "JBPM_ID_PERMISSIONS" cascade constraints;
  DROP TABLE "JBPM_ID_USER" cascade constraints;
  DROP TABLE "JBPM_JOB" cascade constraints;
  DROP TABLE "JBPM_LOG" cascade constraints;
  DROP TABLE "JBPM_MODULEDEFINITION" cascade constraints;
  DROP TABLE "JBPM_MODULEINSTANCE" cascade constraints;
  DROP TABLE "JBPM_NODE" cascade constraints;
  DROP TABLE "JBPM_POOLEDACTOR" cascade constraints;
  DROP TABLE "JBPM_PROCESSDEFINITION" cascade constraints;
  DROP TABLE "JBPM_PROCESSINSTANCE" cascade constraints;
  DROP TABLE "JBPM_RUNTIMEACTION" cascade constraints;
  DROP TABLE "JBPM_SWIMLANE" cascade constraints;
  DROP TABLE "JBPM_SWIMLANEINSTANCE" cascade constraints;
  DROP TABLE "JBPM_TASK" cascade constraints;
  DROP TABLE "JBPM_TASKACTORPOOL" cascade constraints;
  DROP TABLE "JBPM_TASKCONTROLLER" cascade constraints;
  DROP TABLE "JBPM_TASKINSTANCE" cascade constraints;
  DROP TABLE "JBPM_TOKEN" cascade constraints;
  DROP TABLE "JBPM_TOKENVARIABLEMAP" cascade constraints;
  DROP TABLE "JBPM_TRANSITION" cascade constraints;
  DROP TABLE "JBPM_VARIABLEACCESS" cascade constraints;
  DROP TABLE "JBPM_VARIABLEINSTANCE" cascade constraints;
  DROP SEQUENCE "HIBERNATE_SEQUENCE";
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table JBPM_ACTION
--------------------------------------------------------

  CREATE TABLE "JBPM_ACTION" 
   (	"ID_" NUMBER(19,0), 
	"CLASS" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"ISPROPAGATIONALLOWED_" NUMBER(1,0), 
	"ACTIONEXPRESSION_" VARCHAR2(255), 
	"ISASYNC_" NUMBER(1,0), 
	"REFERENCEDACTION_" NUMBER(19,0), 
	"ACTIONDELEGATION_" NUMBER(19,0), 
	"EVENT_" NUMBER(19,0), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"EXPRESSION_" VARCHAR2(4000), 
	"TIMERNAME_" VARCHAR2(255), 
	"DUEDATE_" VARCHAR2(255), 
	"REPEAT_" VARCHAR2(255), 
	"TRANSITIONNAME_" VARCHAR2(255), 
	"TIMERACTION_" NUMBER(19,0), 
	"EVENTINDEX_" NUMBER(10,0), 
	"EXCEPTIONHANDLER_" NUMBER(19,0), 
	"EXCEPTIONHANDLERINDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_BYTEARRAY
--------------------------------------------------------

  CREATE TABLE "JBPM_BYTEARRAY" 
   (	"ID_" NUMBER(19,0), 
	"NAME_" VARCHAR2(255), 
	"FILEDEFINITION_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_BYTEBLOCK
--------------------------------------------------------

  CREATE TABLE "JBPM_BYTEBLOCK" 
   (	"PROCESSFILE_" NUMBER(19,0), 
	"BYTES_" RAW(1024), 
	"INDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_COMMENT
--------------------------------------------------------

  CREATE TABLE "JBPM_COMMENT" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"ACTORID_" VARCHAR2(255), 
	"TIME_" DATE, 
	"MESSAGE_" VARCHAR2(4000), 
	"TOKEN_" NUMBER(19,0), 
	"TASKINSTANCE_" NUMBER(19,0), 
	"TOKENINDEX_" NUMBER(10,0), 
	"TASKINSTANCEINDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_DECISIONCONDITIONS
--------------------------------------------------------

  CREATE TABLE "JBPM_DECISIONCONDITIONS" 
   (	"DECISION_" NUMBER(19,0), 
	"TRANSITIONNAME_" VARCHAR2(255), 
	"EXPRESSION_" VARCHAR2(255), 
	"INDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_DELEGATION
--------------------------------------------------------

  CREATE TABLE "JBPM_DELEGATION" 
   (	"ID_" NUMBER(19,0), 
	"CLASSNAME_" VARCHAR2(4000), 
	"CONFIGURATION_" VARCHAR2(4000), 
	"CONFIGTYPE_" VARCHAR2(255), 
	"PROCESSDEFINITION_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_EVENT
--------------------------------------------------------

  CREATE TABLE "JBPM_EVENT" 
   (	"ID_" NUMBER(19,0), 
	"EVENTTYPE_" VARCHAR2(255), 
	"TYPE_" CHAR(1), 
	"GRAPHELEMENT_" NUMBER(19,0), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"NODE_" NUMBER(19,0), 
	"TRANSITION_" NUMBER(19,0), 
	"TASK_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_EXCEPTIONHANDLER
--------------------------------------------------------

  CREATE TABLE "JBPM_EXCEPTIONHANDLER" 
   (	"ID_" NUMBER(19,0), 
	"EXCEPTIONCLASSNAME_" VARCHAR2(4000), 
	"TYPE_" CHAR(1), 
	"GRAPHELEMENT_" NUMBER(19,0), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"GRAPHELEMENTINDEX_" NUMBER(10,0), 
	"NODE_" NUMBER(19,0), 
	"TRANSITION_" NUMBER(19,0), 
	"TASK_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_ID_GROUP
--------------------------------------------------------

  CREATE TABLE "JBPM_ID_GROUP" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"TYPE_" VARCHAR2(255), 
	"PARENT_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_ID_MEMBERSHIP
--------------------------------------------------------

  CREATE TABLE "JBPM_ID_MEMBERSHIP" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"ROLE_" VARCHAR2(255), 
	"USER_" NUMBER(19,0), 
	"GROUP_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_ID_PERMISSIONS
--------------------------------------------------------

  CREATE TABLE "JBPM_ID_PERMISSIONS" 
   (	"ENTITY_" NUMBER(19,0), 
	"CLASS_" VARCHAR2(255), 
	"NAME_" VARCHAR2(255), 
	"ACTION_" VARCHAR2(255)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_ID_USER
--------------------------------------------------------

  CREATE TABLE "JBPM_ID_USER" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"EMAIL_" VARCHAR2(255), 
	"PASSWORD_" VARCHAR2(255)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_JOB
--------------------------------------------------------

  CREATE TABLE "JBPM_JOB" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"VERSION_" NUMBER(10,0), 
	"DUEDATE_" DATE, 
	"PROCESSINSTANCE_" NUMBER(19,0), 
	"TOKEN_" NUMBER(19,0), 
	"TASKINSTANCE_" NUMBER(19,0), 
	"ISSUSPENDED_" NUMBER(1,0), 
	"ISEXCLUSIVE_" NUMBER(1,0), 
	"LOCKOWNER_" VARCHAR2(255), 
	"LOCKTIME_" DATE, 
	"EXCEPTION_" VARCHAR2(4000), 
	"RETRIES_" NUMBER(10,0), 
	"NAME_" VARCHAR2(255), 
	"REPEAT_" VARCHAR2(255), 
	"TRANSITIONNAME_" VARCHAR2(255), 
	"ACTION_" NUMBER(19,0), 
	"GRAPHELEMENTTYPE_" VARCHAR2(255), 
	"GRAPHELEMENT_" NUMBER(19,0), 
	"NODE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_LOG
--------------------------------------------------------

  CREATE TABLE "JBPM_LOG" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"INDEX_" NUMBER(10,0), 
	"DATE_" DATE, 
	"TOKEN_" NUMBER(19,0), 
	"PARENT_" NUMBER(19,0), 
	"MESSAGE_" VARCHAR2(4000), 
	"EXCEPTION_" VARCHAR2(4000), 
	"ACTION_" NUMBER(19,0), 
	"NODE_" NUMBER(19,0), 
	"ENTER_" DATE, 
	"LEAVE_" DATE, 
	"DURATION_" NUMBER(19,0), 
	"NEWLONGVALUE_" NUMBER(19,0), 
	"TRANSITION_" NUMBER(19,0), 
	"CHILD_" NUMBER(19,0), 
	"SOURCENODE_" NUMBER(19,0), 
	"DESTINATIONNODE_" NUMBER(19,0), 
	"VARIABLEINSTANCE_" NUMBER(19,0), 
	"OLDBYTEARRAY_" NUMBER(19,0), 
	"NEWBYTEARRAY_" NUMBER(19,0), 
	"OLDDATEVALUE_" DATE, 
	"NEWDATEVALUE_" DATE, 
	"OLDDOUBLEVALUE_" FLOAT(126), 
	"NEWDOUBLEVALUE_" FLOAT(126), 
	"OLDLONGIDCLASS_" VARCHAR2(255), 
	"OLDLONGIDVALUE_" NUMBER(19,0), 
	"NEWLONGIDCLASS_" VARCHAR2(255), 
	"NEWLONGIDVALUE_" NUMBER(19,0), 
	"OLDSTRINGIDCLASS_" VARCHAR2(255), 
	"OLDSTRINGIDVALUE_" VARCHAR2(255), 
	"NEWSTRINGIDCLASS_" VARCHAR2(255), 
	"NEWSTRINGIDVALUE_" VARCHAR2(255), 
	"OLDLONGVALUE_" NUMBER(19,0), 
	"OLDSTRINGVALUE_" VARCHAR2(4000), 
	"NEWSTRINGVALUE_" VARCHAR2(4000), 
	"TASKINSTANCE_" NUMBER(19,0), 
	"TASKACTORID_" VARCHAR2(255), 
	"TASKOLDACTORID_" VARCHAR2(255), 
	"SWIMLANEINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_MODULEDEFINITION
--------------------------------------------------------

  CREATE TABLE "JBPM_MODULEDEFINITION" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(4000), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"STARTTASK_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_MODULEINSTANCE
--------------------------------------------------------

  CREATE TABLE "JBPM_MODULEINSTANCE" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"VERSION_" NUMBER(10,0), 
	"PROCESSINSTANCE_" NUMBER(19,0), 
	"TASKMGMTDEFINITION_" NUMBER(19,0), 
	"NAME_" VARCHAR2(255)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_NODE
--------------------------------------------------------

  CREATE TABLE "JBPM_NODE" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"DESCRIPTION_" VARCHAR2(4000), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"ISASYNC_" NUMBER(1,0), 
	"ISASYNCEXCL_" NUMBER(1,0), 
	"ACTION_" NUMBER(19,0), 
	"SUPERSTATE_" NUMBER(19,0), 
	"SUBPROCNAME_" VARCHAR2(255), 
	"SUBPROCESSDEFINITION_" NUMBER(19,0), 
	"DECISIONEXPRESSION_" VARCHAR2(255), 
	"DECISIONDELEGATION" NUMBER(19,0), 
	"SCRIPT_" NUMBER(19,0), 
	"SIGNAL_" NUMBER(10,0), 
	"CREATETASKS_" NUMBER(1,0), 
	"ENDTASKS_" NUMBER(1,0), 
	"NODECOLLECTIONINDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_POOLEDACTOR
--------------------------------------------------------

  CREATE TABLE "JBPM_POOLEDACTOR" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"ACTORID_" VARCHAR2(255), 
	"SWIMLANEINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_PROCESSDEFINITION
--------------------------------------------------------

  CREATE TABLE "JBPM_PROCESSDEFINITION" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"NAME_" VARCHAR2(255), 
	"DESCRIPTION_" VARCHAR2(4000), 
	"VERSION_" NUMBER(10,0), 
	"ISTERMINATIONIMPLICIT_" NUMBER(1,0), 
	"STARTSTATE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_PROCESSINSTANCE
--------------------------------------------------------

  CREATE TABLE "JBPM_PROCESSINSTANCE" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"KEY_" VARCHAR2(255), 
	"START_" DATE, 
	"END_" DATE, 
	"ISSUSPENDED_" NUMBER(1,0), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"ROOTTOKEN_" NUMBER(19,0), 
	"SUPERPROCESSTOKEN_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_RUNTIMEACTION
--------------------------------------------------------

  CREATE TABLE "JBPM_RUNTIMEACTION" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"EVENTTYPE_" VARCHAR2(255), 
	"TYPE_" CHAR(1), 
	"GRAPHELEMENT_" NUMBER(19,0), 
	"PROCESSINSTANCE_" NUMBER(19,0), 
	"ACTION_" NUMBER(19,0), 
	"PROCESSINSTANCEINDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_SWIMLANE
--------------------------------------------------------

  CREATE TABLE "JBPM_SWIMLANE" 
   (	"ID_" NUMBER(19,0), 
	"NAME_" VARCHAR2(255), 
	"ACTORIDEXPRESSION_" VARCHAR2(255), 
	"POOLEDACTORSEXPRESSION_" VARCHAR2(255), 
	"ASSIGNMENTDELEGATION_" NUMBER(19,0), 
	"TASKMGMTDEFINITION_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_SWIMLANEINSTANCE
--------------------------------------------------------

  CREATE TABLE "JBPM_SWIMLANEINSTANCE" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"NAME_" VARCHAR2(255), 
	"ACTORID_" VARCHAR2(255), 
	"SWIMLANE_" NUMBER(19,0), 
	"TASKMGMTINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TASK
--------------------------------------------------------

  CREATE TABLE "JBPM_TASK" 
   (	"ID_" NUMBER(19,0), 
	"NAME_" VARCHAR2(255), 
	"DESCRIPTION_" VARCHAR2(4000), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"ISBLOCKING_" NUMBER(1,0), 
	"ISSIGNALLING_" NUMBER(1,0), 
	"CONDITION_" VARCHAR2(255), 
	"DUEDATE_" VARCHAR2(255), 
	"PRIORITY_" NUMBER(10,0), 
	"ACTORIDEXPRESSION_" VARCHAR2(255), 
	"POOLEDACTORSEXPRESSION_" VARCHAR2(255), 
	"TASKMGMTDEFINITION_" NUMBER(19,0), 
	"TASKNODE_" NUMBER(19,0), 
	"STARTSTATE_" NUMBER(19,0), 
	"ASSIGNMENTDELEGATION_" NUMBER(19,0), 
	"SWIMLANE_" NUMBER(19,0), 
	"TASKCONTROLLER_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TASKACTORPOOL
--------------------------------------------------------

  CREATE TABLE "JBPM_TASKACTORPOOL" 
   (	"TASKINSTANCE_" NUMBER(19,0), 
	"POOLEDACTOR_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TASKCONTROLLER
--------------------------------------------------------

  CREATE TABLE "JBPM_TASKCONTROLLER" 
   (	"ID_" NUMBER(19,0), 
	"TASKCONTROLLERDELEGATION_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TASKINSTANCE
--------------------------------------------------------

  CREATE TABLE "JBPM_TASKINSTANCE" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"VERSION_" NUMBER(10,0), 
	"NAME_" VARCHAR2(255), 
	"DESCRIPTION_" VARCHAR2(4000), 
	"ACTORID_" VARCHAR2(255), 
	"CREATE_" DATE, 
	"START_" DATE, 
	"END_" DATE, 
	"DUEDATE_" DATE, 
	"PRIORITY_" NUMBER(10,0), 
	"ISCANCELLED_" NUMBER(1,0), 
	"ISSUSPENDED_" NUMBER(1,0), 
	"ISOPEN_" NUMBER(1,0), 
	"ISSIGNALLING_" NUMBER(1,0), 
	"ISBLOCKING_" NUMBER(1,0), 
	"TASK_" NUMBER(19,0), 
	"TOKEN_" NUMBER(19,0), 
	"PROCINST_" NUMBER(19,0), 
	"SWIMLANINSTANCE_" NUMBER(19,0), 
	"TASKMGMTINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TOKEN
--------------------------------------------------------

  CREATE TABLE "JBPM_TOKEN" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"NAME_" VARCHAR2(255), 
	"START_" DATE, 
	"END_" DATE, 
	"NODEENTER_" DATE, 
	"NEXTLOGINDEX_" NUMBER(10,0), 
	"ISABLETOREACTIVATEPARENT_" NUMBER(1,0), 
	"ISTERMINATIONIMPLICIT_" NUMBER(1,0), 
	"ISSUSPENDED_" NUMBER(1,0), 
	"LOCK_" VARCHAR2(255), 
	"NODE_" NUMBER(19,0), 
	"PROCESSINSTANCE_" NUMBER(19,0), 
	"PARENT_" NUMBER(19,0), 
	"SUBPROCESSINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TOKENVARIABLEMAP
--------------------------------------------------------

  CREATE TABLE "JBPM_TOKENVARIABLEMAP" 
   (	"ID_" NUMBER(19,0), 
	"VERSION_" NUMBER(10,0), 
	"TOKEN_" NUMBER(19,0), 
	"CONTEXTINSTANCE_" NUMBER(19,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_TRANSITION
--------------------------------------------------------

  CREATE TABLE "JBPM_TRANSITION" 
   (	"ID_" NUMBER(19,0), 
	"NAME_" VARCHAR2(255), 
	"DESCRIPTION_" VARCHAR2(4000), 
	"PROCESSDEFINITION_" NUMBER(19,0), 
	"FROM_" NUMBER(19,0), 
	"TO_" NUMBER(19,0), 
	"CONDITION_" VARCHAR2(255), 
	"FROMINDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_VARIABLEACCESS
--------------------------------------------------------

  CREATE TABLE "JBPM_VARIABLEACCESS" 
   (	"ID_" NUMBER(19,0), 
	"VARIABLENAME_" VARCHAR2(255), 
	"ACCESS_" VARCHAR2(255), 
	"MAPPEDNAME_" VARCHAR2(255), 
	"SCRIPT_" NUMBER(19,0), 
	"PROCESSSTATE_" NUMBER(19,0), 
	"TASKCONTROLLER_" NUMBER(19,0), 
	"INDEX_" NUMBER(10,0)
   ) ;
--------------------------------------------------------
--  DDL for Table JBPM_VARIABLEINSTANCE
--------------------------------------------------------

  CREATE TABLE "JBPM_VARIABLEINSTANCE" 
   (	"ID_" NUMBER(19,0), 
	"CLASS_" CHAR(1), 
	"VERSION_" NUMBER(10,0), 
	"NAME_" VARCHAR2(255), 
	"CONVERTER_" CHAR(1), 
	"TOKEN_" NUMBER(19,0), 
	"TOKENVARIABLEMAP_" NUMBER(19,0), 
	"PROCESSINSTANCE_" NUMBER(19,0), 
	"BYTEARRAYVALUE_" NUMBER(19,0), 
	"DATEVALUE_" DATE, 
	"DOUBLEVALUE_" FLOAT(126), 
	"LONGIDCLASS_" VARCHAR2(255), 
	"LONGVALUE_" NUMBER(19,0), 
	"STRINGIDCLASS_" VARCHAR2(255), 
	"STRINGVALUE_" VARCHAR2(4000), 
	"TASKINSTANCE_" NUMBER(19,0)
   ) ;

---------------------------------------------------
--   DATA FOR TABLE JBPM_ACTION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_ACTION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_ACTION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_BYTEARRAY
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_BYTEARRAY

---------------------------------------------------
--   END DATA FOR TABLE JBPM_BYTEARRAY
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_BYTEBLOCK
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_BYTEBLOCK

---------------------------------------------------
--   END DATA FOR TABLE JBPM_BYTEBLOCK
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_COMMENT
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_COMMENT

---------------------------------------------------
--   END DATA FOR TABLE JBPM_COMMENT
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_DECISIONCONDITIONS
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_DECISIONCONDITIONS

---------------------------------------------------
--   END DATA FOR TABLE JBPM_DECISIONCONDITIONS
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_DELEGATION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_DELEGATION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_DELEGATION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_EVENT
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_EVENT

---------------------------------------------------
--   END DATA FOR TABLE JBPM_EVENT
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_EXCEPTIONHANDLER
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_EXCEPTIONHANDLER

---------------------------------------------------
--   END DATA FOR TABLE JBPM_EXCEPTIONHANDLER
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_ID_GROUP
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_ID_GROUP

---------------------------------------------------
--   END DATA FOR TABLE JBPM_ID_GROUP
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_ID_MEMBERSHIP
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_ID_MEMBERSHIP

---------------------------------------------------
--   END DATA FOR TABLE JBPM_ID_MEMBERSHIP
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_ID_PERMISSIONS
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_ID_PERMISSIONS

---------------------------------------------------
--   END DATA FOR TABLE JBPM_ID_PERMISSIONS
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_ID_USER
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_ID_USER

---------------------------------------------------
--   END DATA FOR TABLE JBPM_ID_USER
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_JOB
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_JOB

---------------------------------------------------
--   END DATA FOR TABLE JBPM_JOB
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_LOG
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_LOG

---------------------------------------------------
--   END DATA FOR TABLE JBPM_LOG
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_MODULEDEFINITION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_MODULEDEFINITION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_MODULEDEFINITION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_MODULEINSTANCE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_MODULEINSTANCE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_MODULEINSTANCE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_NODE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_NODE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_NODE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_POOLEDACTOR
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_POOLEDACTOR

---------------------------------------------------
--   END DATA FOR TABLE JBPM_POOLEDACTOR
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_PROCESSDEFINITION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_PROCESSDEFINITION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_PROCESSDEFINITION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_PROCESSINSTANCE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_PROCESSINSTANCE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_PROCESSINSTANCE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_RUNTIMEACTION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_RUNTIMEACTION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_RUNTIMEACTION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_SWIMLANE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_SWIMLANE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_SWIMLANE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_SWIMLANEINSTANCE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_SWIMLANEINSTANCE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_SWIMLANEINSTANCE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TASK
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TASK

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TASK
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TASKACTORPOOL
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TASKACTORPOOL

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TASKACTORPOOL
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TASKCONTROLLER
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TASKCONTROLLER

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TASKCONTROLLER
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TASKINSTANCE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TASKINSTANCE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TASKINSTANCE
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TOKEN
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TOKEN

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TOKEN
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TOKENVARIABLEMAP
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TOKENVARIABLEMAP

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TOKENVARIABLEMAP
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_TRANSITION
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_TRANSITION

---------------------------------------------------
--   END DATA FOR TABLE JBPM_TRANSITION
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_VARIABLEACCESS
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_VARIABLEACCESS

---------------------------------------------------
--   END DATA FOR TABLE JBPM_VARIABLEACCESS
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE JBPM_VARIABLEINSTANCE
--   FILTER = none used
---------------------------------------------------
REM INSERTING into JBPM_VARIABLEINSTANCE

---------------------------------------------------
--   END DATA FOR TABLE JBPM_VARIABLEINSTANCE
---------------------------------------------------
--------------------------------------------------------
--  Constraints for Table JBPM_ACTION
--------------------------------------------------------

  ALTER TABLE "JBPM_ACTION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ACTION" MODIFY ("CLASS" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ACTION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_BYTEARRAY
--------------------------------------------------------

  ALTER TABLE "JBPM_BYTEARRAY" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_BYTEARRAY" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_BYTEBLOCK
--------------------------------------------------------

  ALTER TABLE "JBPM_BYTEBLOCK" MODIFY ("PROCESSFILE_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_BYTEBLOCK" MODIFY ("INDEX_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_BYTEBLOCK" ADD PRIMARY KEY ("PROCESSFILE_", "INDEX_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_COMMENT
--------------------------------------------------------

  ALTER TABLE "JBPM_COMMENT" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_COMMENT" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_COMMENT" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_DECISIONCONDITIONS
--------------------------------------------------------

  ALTER TABLE "JBPM_DECISIONCONDITIONS" MODIFY ("DECISION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_DECISIONCONDITIONS" MODIFY ("INDEX_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_DECISIONCONDITIONS" ADD PRIMARY KEY ("DECISION_", "INDEX_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_DELEGATION
--------------------------------------------------------

  ALTER TABLE "JBPM_DELEGATION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_DELEGATION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_EVENT
--------------------------------------------------------

  ALTER TABLE "JBPM_EVENT" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_EVENT" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_EXCEPTIONHANDLER
--------------------------------------------------------

  ALTER TABLE "JBPM_EXCEPTIONHANDLER" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_EXCEPTIONHANDLER" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_ID_GROUP
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_GROUP" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_GROUP" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_GROUP" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_ID_MEMBERSHIP
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_MEMBERSHIP" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_MEMBERSHIP" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_MEMBERSHIP" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_ID_PERMISSIONS
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_PERMISSIONS" MODIFY ("ENTITY_" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table JBPM_ID_USER
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_USER" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_USER" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_ID_USER" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_JOB
--------------------------------------------------------

  ALTER TABLE "JBPM_JOB" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_JOB" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_JOB" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_JOB" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_LOG
--------------------------------------------------------

  ALTER TABLE "JBPM_LOG" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_LOG" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_LOG" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_MODULEDEFINITION
--------------------------------------------------------

  ALTER TABLE "JBPM_MODULEDEFINITION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_MODULEDEFINITION" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_MODULEDEFINITION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_MODULEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_MODULEINSTANCE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_MODULEINSTANCE" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_MODULEINSTANCE" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_MODULEINSTANCE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_NODE
--------------------------------------------------------

  ALTER TABLE "JBPM_NODE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_NODE" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_NODE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_POOLEDACTOR
--------------------------------------------------------

  ALTER TABLE "JBPM_POOLEDACTOR" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_POOLEDACTOR" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_POOLEDACTOR" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_PROCESSDEFINITION
--------------------------------------------------------

  ALTER TABLE "JBPM_PROCESSDEFINITION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_PROCESSDEFINITION" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_PROCESSDEFINITION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_PROCESSINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_PROCESSINSTANCE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_PROCESSINSTANCE" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_PROCESSINSTANCE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_RUNTIMEACTION
--------------------------------------------------------

  ALTER TABLE "JBPM_RUNTIMEACTION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_RUNTIMEACTION" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_RUNTIMEACTION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_SWIMLANE
--------------------------------------------------------

  ALTER TABLE "JBPM_SWIMLANE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_SWIMLANE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_SWIMLANEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_SWIMLANEINSTANCE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_SWIMLANEINSTANCE" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_SWIMLANEINSTANCE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TASK
--------------------------------------------------------

  ALTER TABLE "JBPM_TASK" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASK" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TASKACTORPOOL
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKACTORPOOL" MODIFY ("TASKINSTANCE_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKACTORPOOL" MODIFY ("POOLEDACTOR_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKACTORPOOL" ADD PRIMARY KEY ("TASKINSTANCE_", "POOLEDACTOR_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TASKCONTROLLER
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKCONTROLLER" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKCONTROLLER" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TASKINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKINSTANCE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKINSTANCE" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKINSTANCE" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TASKINSTANCE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TOKEN
--------------------------------------------------------

  ALTER TABLE "JBPM_TOKEN" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TOKEN" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TOKEN" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TOKENVARIABLEMAP
--------------------------------------------------------

  ALTER TABLE "JBPM_TOKENVARIABLEMAP" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TOKENVARIABLEMAP" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TOKENVARIABLEMAP" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_TRANSITION
--------------------------------------------------------

  ALTER TABLE "JBPM_TRANSITION" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_TRANSITION" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_VARIABLEACCESS
--------------------------------------------------------

  ALTER TABLE "JBPM_VARIABLEACCESS" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_VARIABLEACCESS" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  Constraints for Table JBPM_VARIABLEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_VARIABLEINSTANCE" MODIFY ("ID_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" MODIFY ("CLASS_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" MODIFY ("VERSION_" NOT NULL ENABLE);
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD PRIMARY KEY ("ID_") ENABLE;
--------------------------------------------------------
--  DDL for Index SYS_C006751
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006751" ON "JBPM_ACTION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_ACTION_ACTNDL
--------------------------------------------------------

  CREATE INDEX "IDX_ACTION_ACTNDL" ON "JBPM_ACTION" ("ACTIONDELEGATION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_ACTION_PROCDF
--------------------------------------------------------

  CREATE INDEX "IDX_ACTION_PROCDF" ON "JBPM_ACTION" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_ACTION_EVENT
--------------------------------------------------------

  CREATE INDEX "IDX_ACTION_EVENT" ON "JBPM_ACTION" ("EVENT_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006753
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006753" ON "JBPM_BYTEARRAY" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006756
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006756" ON "JBPM_BYTEBLOCK" ("PROCESSFILE_", "INDEX_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006759
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006759" ON "JBPM_COMMENT" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_COMMENT_TSK
--------------------------------------------------------

  CREATE INDEX "IDX_COMMENT_TSK" ON "JBPM_COMMENT" ("TASKINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_COMMENT_TOKEN
--------------------------------------------------------

  CREATE INDEX "IDX_COMMENT_TOKEN" ON "JBPM_COMMENT" ("TOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006762
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006762" ON "JBPM_DECISIONCONDITIONS" ("DECISION_", "INDEX_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006764
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006764" ON "JBPM_DELEGATION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_DELEG_PRCD
--------------------------------------------------------

  CREATE INDEX "IDX_DELEG_PRCD" ON "JBPM_DELEGATION" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006766
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006766" ON "JBPM_EVENT" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006768
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006768" ON "JBPM_EXCEPTIONHANDLER" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006771
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006771" ON "JBPM_ID_GROUP" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006774
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006774" ON "JBPM_ID_MEMBERSHIP" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006778
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006778" ON "JBPM_ID_USER" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_JOB_PRINST
--------------------------------------------------------

  CREATE INDEX "IDX_JOB_PRINST" ON "JBPM_JOB" ("PROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006782
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006782" ON "JBPM_JOB" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_JOB_TSKINST
--------------------------------------------------------

  CREATE INDEX "IDX_JOB_TSKINST" ON "JBPM_JOB" ("TASKINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_JOB_TOKEN
--------------------------------------------------------

  CREATE INDEX "IDX_JOB_TOKEN" ON "JBPM_JOB" ("TOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006785
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006785" ON "JBPM_LOG" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_MODDEF_PROCDF
--------------------------------------------------------

  CREATE INDEX "IDX_MODDEF_PROCDF" ON "JBPM_MODULEDEFINITION" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006788
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006788" ON "JBPM_MODULEDEFINITION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_MODINST_PRINST
--------------------------------------------------------

  CREATE INDEX "IDX_MODINST_PRINST" ON "JBPM_MODULEINSTANCE" ("PROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006792
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006792" ON "JBPM_MODULEINSTANCE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PSTATE_SBPRCDEF
--------------------------------------------------------

  CREATE INDEX "IDX_PSTATE_SBPRCDEF" ON "JBPM_NODE" ("SUBPROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NODE_PROCDEF
--------------------------------------------------------

  CREATE INDEX "IDX_NODE_PROCDEF" ON "JBPM_NODE" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NODE_ACTION
--------------------------------------------------------

  CREATE INDEX "IDX_NODE_ACTION" ON "JBPM_NODE" ("ACTION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_NODE_SUPRSTATE
--------------------------------------------------------

  CREATE INDEX "IDX_NODE_SUPRSTATE" ON "JBPM_NODE" ("SUPERSTATE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006795
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006795" ON "JBPM_NODE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TSKINST_SWLANE
--------------------------------------------------------

  CREATE INDEX "IDX_TSKINST_SWLANE" ON "JBPM_POOLEDACTOR" ("SWIMLANEINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PLDACTR_ACTID
--------------------------------------------------------

  CREATE INDEX "IDX_PLDACTR_ACTID" ON "JBPM_POOLEDACTOR" ("ACTORID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006798
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006798" ON "JBPM_POOLEDACTOR" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PROCDEF_STRTST
--------------------------------------------------------

  CREATE INDEX "IDX_PROCDEF_STRTST" ON "JBPM_PROCESSDEFINITION" ("STARTSTATE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006801
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006801" ON "JBPM_PROCESSDEFINITION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PROCIN_SPROCTK
--------------------------------------------------------

  CREATE INDEX "IDX_PROCIN_SPROCTK" ON "JBPM_PROCESSINSTANCE" ("SUPERPROCESSTOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PROCIN_ROOTTK
--------------------------------------------------------

  CREATE INDEX "IDX_PROCIN_ROOTTK" ON "JBPM_PROCESSINSTANCE" ("ROOTTOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PROCIN_PROCDEF
--------------------------------------------------------

  CREATE INDEX "IDX_PROCIN_PROCDEF" ON "JBPM_PROCESSINSTANCE" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_PROCIN_KEY
--------------------------------------------------------

  CREATE INDEX "IDX_PROCIN_KEY" ON "JBPM_PROCESSINSTANCE" ("KEY_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006804
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006804" ON "JBPM_PROCESSINSTANCE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_RTACTN_ACTION
--------------------------------------------------------

  CREATE INDEX "IDX_RTACTN_ACTION" ON "JBPM_RUNTIMEACTION" ("ACTION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_RTACTN_PRCINST
--------------------------------------------------------

  CREATE INDEX "IDX_RTACTN_PRCINST" ON "JBPM_RUNTIMEACTION" ("PROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006807
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006807" ON "JBPM_RUNTIMEACTION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006809
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006809" ON "JBPM_SWIMLANE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_SWIMLINST_SL
--------------------------------------------------------

  CREATE INDEX "IDX_SWIMLINST_SL" ON "JBPM_SWIMLANEINSTANCE" ("SWIMLANE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006812
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006812" ON "JBPM_SWIMLANEINSTANCE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASK_PROCDEF
--------------------------------------------------------

  CREATE INDEX "IDX_TASK_PROCDEF" ON "JBPM_TASK" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASK_TSKNODE
--------------------------------------------------------

  CREATE INDEX "IDX_TASK_TSKNODE" ON "JBPM_TASK" ("TASKNODE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASK_TASKMGTDF
--------------------------------------------------------

  CREATE INDEX "IDX_TASK_TASKMGTDF" ON "JBPM_TASK" ("TASKMGMTDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006814
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006814" ON "JBPM_TASK" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006817
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006817" ON "JBPM_TASKACTORPOOL" ("TASKINSTANCE_", "POOLEDACTOR_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006819
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006819" ON "JBPM_TASKCONTROLLER" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TSKINST_TMINST
--------------------------------------------------------

  CREATE INDEX "IDX_TSKINST_TMINST" ON "JBPM_TASKINSTANCE" ("TASKMGMTINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TSKINST_SLINST
--------------------------------------------------------

  CREATE INDEX "IDX_TSKINST_SLINST" ON "JBPM_TASKINSTANCE" ("SWIMLANINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASKINST_TOKN
--------------------------------------------------------

  CREATE INDEX "IDX_TASKINST_TOKN" ON "JBPM_TASKINSTANCE" ("TOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASK_ACTORID
--------------------------------------------------------

  CREATE INDEX "IDX_TASK_ACTORID" ON "JBPM_TASKINSTANCE" ("ACTORID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TASKINST_TSK
--------------------------------------------------------

  CREATE INDEX "IDX_TASKINST_TSK" ON "JBPM_TASKINSTANCE" ("TASK_", "PROCINST_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006823
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006823" ON "JBPM_TASKINSTANCE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TOKEN_PARENT
--------------------------------------------------------

  CREATE INDEX "IDX_TOKEN_PARENT" ON "JBPM_TOKEN" ("PARENT_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TOKEN_PROCIN
--------------------------------------------------------

  CREATE INDEX "IDX_TOKEN_PROCIN" ON "JBPM_TOKEN" ("PROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TOKEN_NODE
--------------------------------------------------------

  CREATE INDEX "IDX_TOKEN_NODE" ON "JBPM_TOKEN" ("NODE_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TOKEN_SUBPI
--------------------------------------------------------

  CREATE INDEX "IDX_TOKEN_SUBPI" ON "JBPM_TOKEN" ("SUBPROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006826
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006826" ON "JBPM_TOKEN" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TKVVARMP_TOKEN
--------------------------------------------------------

  CREATE INDEX "IDX_TKVVARMP_TOKEN" ON "JBPM_TOKENVARIABLEMAP" ("TOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TKVARMAP_CTXT
--------------------------------------------------------

  CREATE INDEX "IDX_TKVARMAP_CTXT" ON "JBPM_TOKENVARIABLEMAP" ("CONTEXTINSTANCE_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006829
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006829" ON "JBPM_TOKENVARIABLEMAP" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TRANS_PROCDEF
--------------------------------------------------------

  CREATE INDEX "IDX_TRANS_PROCDEF" ON "JBPM_TRANSITION" ("PROCESSDEFINITION_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TRANSIT_FROM
--------------------------------------------------------

  CREATE INDEX "IDX_TRANSIT_FROM" ON "JBPM_TRANSITION" ("FROM_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_TRANSIT_TO
--------------------------------------------------------

  CREATE INDEX "IDX_TRANSIT_TO" ON "JBPM_TRANSITION" ("TO_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006831
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006831" ON "JBPM_TRANSITION" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006833
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006833" ON "JBPM_VARIABLEACCESS" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C006837
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006837" ON "JBPM_VARIABLEINSTANCE" ("ID_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_VARINST_TK
--------------------------------------------------------

  CREATE INDEX "IDX_VARINST_TK" ON "JBPM_VARIABLEINSTANCE" ("TOKEN_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_VARINST_TKVARMP
--------------------------------------------------------

  CREATE INDEX "IDX_VARINST_TKVARMP" ON "JBPM_VARIABLEINSTANCE" ("TOKENVARIABLEMAP_") 
  ;
--------------------------------------------------------
--  DDL for Index IDX_VARINST_PRCINS
--------------------------------------------------------

  CREATE INDEX "IDX_VARINST_PRCINS" ON "JBPM_VARIABLEINSTANCE" ("PROCESSINSTANCE_") 
  ;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_ACTION
--------------------------------------------------------

  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_ACTION_ACTNDEL" FOREIGN KEY ("ACTIONDELEGATION_")
	  REFERENCES "JBPM_DELEGATION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_ACTION_EVENT" FOREIGN KEY ("EVENT_")
	  REFERENCES "JBPM_EVENT" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_ACTION_EXPTHDL" FOREIGN KEY ("EXCEPTIONHANDLER_")
	  REFERENCES "JBPM_EXCEPTIONHANDLER" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_ACTION_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_ACTION_REFACT" FOREIGN KEY ("REFERENCEDACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ACTION" ADD CONSTRAINT "FK_CRTETIMERACT_TA" FOREIGN KEY ("TIMERACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_BYTEARRAY
--------------------------------------------------------

  ALTER TABLE "JBPM_BYTEARRAY" ADD CONSTRAINT "FK_BYTEARR_FILDEF" FOREIGN KEY ("FILEDEFINITION_")
	  REFERENCES "JBPM_MODULEDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_BYTEBLOCK
--------------------------------------------------------

  ALTER TABLE "JBPM_BYTEBLOCK" ADD CONSTRAINT "FK_BYTEBLOCK_FILE" FOREIGN KEY ("PROCESSFILE_")
	  REFERENCES "JBPM_BYTEARRAY" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_COMMENT
--------------------------------------------------------

  ALTER TABLE "JBPM_COMMENT" ADD CONSTRAINT "FK_COMMENT_TOKEN" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_COMMENT" ADD CONSTRAINT "FK_COMMENT_TSK" FOREIGN KEY ("TASKINSTANCE_")
	  REFERENCES "JBPM_TASKINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_DECISIONCONDITIONS
--------------------------------------------------------

  ALTER TABLE "JBPM_DECISIONCONDITIONS" ADD CONSTRAINT "FK_DECCOND_DEC" FOREIGN KEY ("DECISION_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_DELEGATION
--------------------------------------------------------

  ALTER TABLE "JBPM_DELEGATION" ADD CONSTRAINT "FK_DELEGATION_PRCD" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_EVENT
--------------------------------------------------------

  ALTER TABLE "JBPM_EVENT" ADD CONSTRAINT "FK_EVENT_NODE" FOREIGN KEY ("NODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_EVENT" ADD CONSTRAINT "FK_EVENT_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_EVENT" ADD CONSTRAINT "FK_EVENT_TASK" FOREIGN KEY ("TASK_")
	  REFERENCES "JBPM_TASK" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_EVENT" ADD CONSTRAINT "FK_EVENT_TRANS" FOREIGN KEY ("TRANSITION_")
	  REFERENCES "JBPM_TRANSITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_ID_GROUP
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_GROUP" ADD CONSTRAINT "FK_ID_GRP_PARENT" FOREIGN KEY ("PARENT_")
	  REFERENCES "JBPM_ID_GROUP" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_ID_MEMBERSHIP
--------------------------------------------------------

  ALTER TABLE "JBPM_ID_MEMBERSHIP" ADD CONSTRAINT "FK_ID_MEMSHIP_GRP" FOREIGN KEY ("GROUP_")
	  REFERENCES "JBPM_ID_GROUP" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_ID_MEMBERSHIP" ADD CONSTRAINT "FK_ID_MEMSHIP_USR" FOREIGN KEY ("USER_")
	  REFERENCES "JBPM_ID_USER" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_JOB
--------------------------------------------------------

  ALTER TABLE "JBPM_JOB" ADD CONSTRAINT "FK_JOB_ACTION" FOREIGN KEY ("ACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_JOB" ADD CONSTRAINT "FK_JOB_NODE" FOREIGN KEY ("NODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_JOB" ADD CONSTRAINT "FK_JOB_PRINST" FOREIGN KEY ("PROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_JOB" ADD CONSTRAINT "FK_JOB_TOKEN" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_JOB" ADD CONSTRAINT "FK_JOB_TSKINST" FOREIGN KEY ("TASKINSTANCE_")
	  REFERENCES "JBPM_TASKINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_LOG
--------------------------------------------------------

  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_ACTION" FOREIGN KEY ("ACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_CHILDTOKEN" FOREIGN KEY ("CHILD_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_DESTNODE" FOREIGN KEY ("DESTINATIONNODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_NEWBYTES" FOREIGN KEY ("NEWBYTEARRAY_")
	  REFERENCES "JBPM_BYTEARRAY" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_NODE" FOREIGN KEY ("NODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_OLDBYTES" FOREIGN KEY ("OLDBYTEARRAY_")
	  REFERENCES "JBPM_BYTEARRAY" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_PARENT" FOREIGN KEY ("PARENT_")
	  REFERENCES "JBPM_LOG" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_SOURCENODE" FOREIGN KEY ("SOURCENODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_SWIMINST" FOREIGN KEY ("SWIMLANEINSTANCE_")
	  REFERENCES "JBPM_SWIMLANEINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_TASKINST" FOREIGN KEY ("TASKINSTANCE_")
	  REFERENCES "JBPM_TASKINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_TOKEN" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_TRANSITION" FOREIGN KEY ("TRANSITION_")
	  REFERENCES "JBPM_TRANSITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_LOG" ADD CONSTRAINT "FK_LOG_VARINST" FOREIGN KEY ("VARIABLEINSTANCE_")
	  REFERENCES "JBPM_VARIABLEINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_MODULEDEFINITION
--------------------------------------------------------

  ALTER TABLE "JBPM_MODULEDEFINITION" ADD CONSTRAINT "FK_MODDEF_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_MODULEDEFINITION" ADD CONSTRAINT "FK_TSKDEF_START" FOREIGN KEY ("STARTTASK_")
	  REFERENCES "JBPM_TASK" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_MODULEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_MODULEINSTANCE" ADD CONSTRAINT "FK_MODINST_PRCINST" FOREIGN KEY ("PROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_MODULEINSTANCE" ADD CONSTRAINT "FK_TASKMGTINST_TMD" FOREIGN KEY ("TASKMGMTDEFINITION_")
	  REFERENCES "JBPM_MODULEDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_NODE
--------------------------------------------------------

  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_DECISION_DELEG" FOREIGN KEY ("DECISIONDELEGATION")
	  REFERENCES "JBPM_DELEGATION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_NODE_ACTION" FOREIGN KEY ("ACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_NODE_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_NODE_SCRIPT" FOREIGN KEY ("SCRIPT_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_NODE_SUPERSTATE" FOREIGN KEY ("SUPERSTATE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_NODE" ADD CONSTRAINT "FK_PROCST_SBPRCDEF" FOREIGN KEY ("SUBPROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_POOLEDACTOR
--------------------------------------------------------

  ALTER TABLE "JBPM_POOLEDACTOR" ADD CONSTRAINT "FK_POOLEDACTOR_SLI" FOREIGN KEY ("SWIMLANEINSTANCE_")
	  REFERENCES "JBPM_SWIMLANEINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_PROCESSDEFINITION
--------------------------------------------------------

  ALTER TABLE "JBPM_PROCESSDEFINITION" ADD CONSTRAINT "FK_PROCDEF_STRTSTA" FOREIGN KEY ("STARTSTATE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_PROCESSINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_PROCESSINSTANCE" ADD CONSTRAINT "FK_PROCIN_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_PROCESSINSTANCE" ADD CONSTRAINT "FK_PROCIN_ROOTTKN" FOREIGN KEY ("ROOTTOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_PROCESSINSTANCE" ADD CONSTRAINT "FK_PROCIN_SPROCTKN" FOREIGN KEY ("SUPERPROCESSTOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_RUNTIMEACTION
--------------------------------------------------------

  ALTER TABLE "JBPM_RUNTIMEACTION" ADD CONSTRAINT "FK_RTACTN_ACTION" FOREIGN KEY ("ACTION_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_RUNTIMEACTION" ADD CONSTRAINT "FK_RTACTN_PROCINST" FOREIGN KEY ("PROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_SWIMLANE
--------------------------------------------------------

  ALTER TABLE "JBPM_SWIMLANE" ADD CONSTRAINT "FK_SWL_ASSDEL" FOREIGN KEY ("ASSIGNMENTDELEGATION_")
	  REFERENCES "JBPM_DELEGATION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_SWIMLANE" ADD CONSTRAINT "FK_SWL_TSKMGMTDEF" FOREIGN KEY ("TASKMGMTDEFINITION_")
	  REFERENCES "JBPM_MODULEDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_SWIMLANEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_SWIMLANEINSTANCE" ADD CONSTRAINT "FK_SWIMLANEINST_SL" FOREIGN KEY ("SWIMLANE_")
	  REFERENCES "JBPM_SWIMLANE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_SWIMLANEINSTANCE" ADD CONSTRAINT "FK_SWIMLANEINST_TM" FOREIGN KEY ("TASKMGMTINSTANCE_")
	  REFERENCES "JBPM_MODULEINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TASK
--------------------------------------------------------

  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_ASSDEL" FOREIGN KEY ("ASSIGNMENTDELEGATION_")
	  REFERENCES "JBPM_DELEGATION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_STARTST" FOREIGN KEY ("STARTSTATE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_SWIMLANE" FOREIGN KEY ("SWIMLANE_")
	  REFERENCES "JBPM_SWIMLANE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_TASKMGTDEF" FOREIGN KEY ("TASKMGMTDEFINITION_")
	  REFERENCES "JBPM_MODULEDEFINITION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TASK_TASKNODE" FOREIGN KEY ("TASKNODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASK" ADD CONSTRAINT "FK_TSK_TSKCTRL" FOREIGN KEY ("TASKCONTROLLER_")
	  REFERENCES "JBPM_TASKCONTROLLER" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TASKACTORPOOL
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKACTORPOOL" ADD CONSTRAINT "FK_TASKACTPL_TSKI" FOREIGN KEY ("TASKINSTANCE_")
	  REFERENCES "JBPM_TASKINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASKACTORPOOL" ADD CONSTRAINT "FK_TSKACTPOL_PLACT" FOREIGN KEY ("POOLEDACTOR_")
	  REFERENCES "JBPM_POOLEDACTOR" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TASKCONTROLLER
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKCONTROLLER" ADD CONSTRAINT "FK_TSKCTRL_DELEG" FOREIGN KEY ("TASKCONTROLLERDELEGATION_")
	  REFERENCES "JBPM_DELEGATION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TASKINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_TASKINSTANCE" ADD CONSTRAINT "FK_TASKINST_SLINST" FOREIGN KEY ("SWIMLANINSTANCE_")
	  REFERENCES "JBPM_SWIMLANEINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASKINSTANCE" ADD CONSTRAINT "FK_TASKINST_TASK" FOREIGN KEY ("TASK_")
	  REFERENCES "JBPM_TASK" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASKINSTANCE" ADD CONSTRAINT "FK_TASKINST_TMINST" FOREIGN KEY ("TASKMGMTINSTANCE_")
	  REFERENCES "JBPM_MODULEINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASKINSTANCE" ADD CONSTRAINT "FK_TASKINST_TOKEN" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TASKINSTANCE" ADD CONSTRAINT "FK_TSKINS_PRCINS" FOREIGN KEY ("PROCINST_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TOKEN
--------------------------------------------------------

  ALTER TABLE "JBPM_TOKEN" ADD CONSTRAINT "FK_TOKEN_NODE" FOREIGN KEY ("NODE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TOKEN" ADD CONSTRAINT "FK_TOKEN_PARENT" FOREIGN KEY ("PARENT_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TOKEN" ADD CONSTRAINT "FK_TOKEN_PROCINST" FOREIGN KEY ("PROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TOKEN" ADD CONSTRAINT "FK_TOKEN_SUBPI" FOREIGN KEY ("SUBPROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TOKENVARIABLEMAP
--------------------------------------------------------

  ALTER TABLE "JBPM_TOKENVARIABLEMAP" ADD CONSTRAINT "FK_TKVARMAP_CTXT" FOREIGN KEY ("CONTEXTINSTANCE_")
	  REFERENCES "JBPM_MODULEINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TOKENVARIABLEMAP" ADD CONSTRAINT "FK_TKVARMAP_TOKEN" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_TRANSITION
--------------------------------------------------------

  ALTER TABLE "JBPM_TRANSITION" ADD CONSTRAINT "FK_TRANSITION_FROM" FOREIGN KEY ("FROM_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TRANSITION" ADD CONSTRAINT "FK_TRANSITION_TO" FOREIGN KEY ("TO_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_TRANSITION" ADD CONSTRAINT "FK_TRANS_PROCDEF" FOREIGN KEY ("PROCESSDEFINITION_")
	  REFERENCES "JBPM_PROCESSDEFINITION" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_VARIABLEACCESS
--------------------------------------------------------

  ALTER TABLE "JBPM_VARIABLEACCESS" ADD CONSTRAINT "FK_VARACC_PROCST" FOREIGN KEY ("PROCESSSTATE_")
	  REFERENCES "JBPM_NODE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEACCESS" ADD CONSTRAINT "FK_VARACC_SCRIPT" FOREIGN KEY ("SCRIPT_")
	  REFERENCES "JBPM_ACTION" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEACCESS" ADD CONSTRAINT "FK_VARACC_TSKCTRL" FOREIGN KEY ("TASKCONTROLLER_")
	  REFERENCES "JBPM_TASKCONTROLLER" ("ID_") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table JBPM_VARIABLEINSTANCE
--------------------------------------------------------

  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD CONSTRAINT "FK_BYTEINST_ARRAY" FOREIGN KEY ("BYTEARRAYVALUE_")
	  REFERENCES "JBPM_BYTEARRAY" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD CONSTRAINT "FK_VARINST_PRCINST" FOREIGN KEY ("PROCESSINSTANCE_")
	  REFERENCES "JBPM_PROCESSINSTANCE" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD CONSTRAINT "FK_VARINST_TK" FOREIGN KEY ("TOKEN_")
	  REFERENCES "JBPM_TOKEN" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD CONSTRAINT "FK_VARINST_TKVARMP" FOREIGN KEY ("TOKENVARIABLEMAP_")
	  REFERENCES "JBPM_TOKENVARIABLEMAP" ("ID_") ENABLE;
 
  ALTER TABLE "JBPM_VARIABLEINSTANCE" ADD CONSTRAINT "FK_VAR_TSKINST" FOREIGN KEY ("TASKINSTANCE_")
	  REFERENCES "JBPM_TASKINSTANCE" ("ID_") ENABLE;
