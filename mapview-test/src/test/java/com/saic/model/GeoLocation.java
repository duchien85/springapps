package com.saic.model;

import java.util.Date;

//CREATE TABLE [dbo].[GeoLocations](
//	[GEO_GUID] [uniqueidentifier] NULL,
//	[REPORT_GUID] [uniqueidentifier] NOT NULL,
//	[GUID] [uniqueidentifier] NOT NULL,
//	[From_Date] [datetime] NULL,
//	[To_Date] [datetime] NULL,
//	[Country_Soundex] [nvarchar](50) NULL,
//	[City_Soundex] [nvarchar](50) NULL,
//	[State_Soundex] [nvarchar](50) NULL,
//	[Entity_Type] [nvarchar](50) NULL,
//	[Feature_Type] [nvarchar](50) NULL,
//	[Addr_Type] [nvarchar](20) NULL,
//	[Rel_Src] [int] NULL,
//	[Country] [nvarchar](50) NULL,
//	[State_Province] [nvarchar](50) NULL,
//	[County_District] [nvarchar](50) NULL,
//	[City_Village] [nvarchar](50) NULL,
//	[Section_Region] [nvarchar](50) NULL,
//	[Addr_Str_1] [nvarchar](50) NULL,
//	[Addr_Str_2] [nvarchar](50) NULL,
//	[Loc_Designator] [nvarchar](50) NULL,
//	[PO_Box] [nvarchar](12) NULL,
//	[ZipCode_PostalCode] [nvarchar](25) NULL,
//	[LocationXML] [ntext] NULL,
//	[Comments] [ntext] NULL,
//	[Utility_Field] [nvarchar](255) NULL,
//	[DATECREATED] [datetime] NULL,
//	[LASTMODIFIED] [datetime] NULL,
//	[ENTITYSTATE] [nvarchar](20) NULL,
//	[GeoLocations_RecState] [smallint] NOT NULL,
//	[RecTimestamp] [datetime] NULL,
// CONSTRAINT [PK__GeoLocations__164452B1] PRIMARY KEY NONCLUSTERED
public class GeoLocation {

    private String geoGuid;
    private String reportGuid;
    private String guid;
    private Date fromDate;
    private Date toDate;
    private String countrySoundex;
    private String citySoundex;
    private String stateSoundex;
    private String entityType;
}
