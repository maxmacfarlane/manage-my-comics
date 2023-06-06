-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'manage_my_comics';

DROP DATABASE manage_my_comics;

DROP USER manage_my_comics_owner;
DROP USER manage_my_comics_appuser;
