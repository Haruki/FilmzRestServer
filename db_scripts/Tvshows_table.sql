CREATE TABLE TVSHOWS (
  ID NUMBER NOT NULL,
  NAME VARCHAR2(100) NOT NULL ,
  NAME_ORIGINAL VARCHAR2(100) NOT NULL ,
  RELEASE_DATE DATE,
  IMDB_CODE VARCHAR2(20),
  IMDB_RATING NUMBER(2,1),
  CREATION_DATE DATE NOT NULL,
  FINISHED NUMBER(1)
);

ALTER TABLE TVSHOWS ADD CONSTRAINT PK_TVSHOWS PRIMARY KEY (ID);
ALTER TABLE TVSHOWS ADD CONSTRAINT CHECK_TVSHOWS_FINISHED CHECK (FINISHED in (0,1));
