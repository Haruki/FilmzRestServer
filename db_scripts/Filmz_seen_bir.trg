create or replace TRIGGER FILMZ_SEEN_BIR
BEFORE UPDATE ON FILMZ
FOR EACH ROW

  BEGIN
    if :old.seen = 'false' and :new.seen = 'true' THEN
      :new.seen_time := sysdate;
    END IF;
 END;