
create or replace TRIGGER SEASONS_BIR
BEFORE INSERT ON SEASONS
FOR EACH ROW

  BEGIN
    SELECT BESTFILMZ.FILMZ_MOVIEID_SEQ.NEXTVAL
    INTO   :new.id
    FROM   dual;
    :new.CREATION_TIME := sysdate;
  END;



