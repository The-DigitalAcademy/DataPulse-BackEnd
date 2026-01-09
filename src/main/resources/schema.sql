-- Drop tables if they exist to ensure a clean start
--DROP TABLE IF EXISTS users;
--DROP TABLE IF EXISTS surveys;
--DROP TABLE IF EXISTS question;
--DROP TABLE IF EXISTS choice;
--DROP TABLE IF EXISTS response;
--DROP TABLE IF EXISTS answer;

-- Create Users table
CREATE TABLE IF NOT EXISTS users (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     name VARCHAR(255) NOT NULL,
     surname VARCHAR(255) NOT NULL,
     email VARCHAR(255) UNIQUE NOT NULL,
     role VARCHAR(50) NOT NULL,
     password VARCHAR(255) NOT NULL
 );

-- other tables.
CREATE TABLE IF NOT EXISTS surveys (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    is_open BOOLEAN NOT NULL DEFAULT true,
    description TEXT,
    coordinator_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_surveys_coordinator
        FOREIGN KEY (coordinator_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS question (
    id SERIAL PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    description TEXT,
    survey_id INTEGER NOT NULL,

    CONSTRAINT fk_question_survey
        FOREIGN KEY (survey_id)
        REFERENCES surveys(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS choice (
    id SERIAL PRIMARY KEY,
    option_text VARCHAR(500) NOT NULL,
    question_id INTEGER NOT NULL,

    CONSTRAINT fk_choice_question
        FOREIGN KEY (question_id)
        REFERENCES question(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS response (
    id SERIAL PRIMARY KEY,
    survey_id INTEGER NOT NULL,
    respondent_id UUID NOT NULL,
    submitted_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_response_survey
        FOREIGN KEY (survey_id)
        REFERENCES surveys(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_response_respondent
        FOREIGN KEY (respondent_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    -- Ensure a user can only submit one response per survey
    CONSTRAINT uk_response_survey_respondent
        UNIQUE (survey_id, respondent_id)
);

CREATE TABLE IF NOT EXISTS answer (
    id SERIAL PRIMARY KEY,
    response_id INTEGER NOT NULL,
    question_id INTEGER NOT NULL,
    choice_id INTEGER,
    text_answer TEXT,

    CONSTRAINT fk_answer_response
        FOREIGN KEY (response_id)
        REFERENCES response(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_answer_question
        FOREIGN KEY (question_id)
        REFERENCES question(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_answer_choice
        FOREIGN KEY (choice_id)
        REFERENCES choice(id)
        ON DELETE SET NULL,

    -- Ensure one answer per question per response
    CONSTRAINT uk_answer_response_question
        UNIQUE (response_id, question_id)
);