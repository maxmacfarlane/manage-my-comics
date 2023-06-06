-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER manage_my_comics_owner
WITH PASSWORD 'password';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO manage_my_comics_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO manage_my_comics_owner;

CREATE USER manage_my_comics_appuser
WITH PASSWORD 'password';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO manage_my_comics_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO manage_my_comics_appuser;
