
create or replace TRIGGER TVSHOWS_BIR
BEFORE INSERT ON TVSHOWS
FOR EACH ROW

  BEGIN
    SELECT BESTFILMZ.FILMZ_MOVIEID_SEQ.NEXTVAL
    INTO   :new.id
    FROM   dual;
    :new.CREATION_DATE := sysdate;
  END;


