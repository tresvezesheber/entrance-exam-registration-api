ALTER TABLE inscription ADD CONSTRAINT
    FOREIGN KEY fk_course_id (course_id) REFERENCES course (id);