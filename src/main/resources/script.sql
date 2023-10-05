DROP TABLE IF EXISTS properties
GO
CREATE TABLE properties (
    [id] INT IDENTITY(1,1) PRIMARY KEY,
    [application] VARCHAR(255),
    [profile] VARCHAR(255),
    [label] VARCHAR(255),
    [key] VARCHAR(255),
    [value] TEXT,
    UNIQUE ([application], [profile], [label], [key])
)
GO

INSERT INTO properties VALUES
('spring-cloud-config-client', 'default', 'latest', 'executor.pool.core-size', '5'),
('spring-cloud-config-client', 'default', 'latest', 'executor.pool.max-size', '10'),
('spring-cloud-config-client', 'default', 'latest', 'executor.pool.capacity', '100'),
('spring-cloud-config-client', 'prod', 'latest', 'executor.pool.core-size', '7'),
('spring-cloud-config-client', 'prod', 'latest', 'executor.pool.max-size', '17'),
('spring-cloud-config-client', 'prod', 'latest', 'executor.pool.capacity', '177')
GO

SELECT * FROM properties