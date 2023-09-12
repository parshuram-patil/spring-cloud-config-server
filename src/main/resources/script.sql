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
-- Default
('application', 'default', 'latest', 'env.name.full', 'Default'),
('application', 'default', 'latest', 'env.name.short', 'DEF'),
('application', 'dev', 'latest', 'env.name.full', 'Development'),
('application', 'dev', 'latest', 'env.name.short', 'DEV'),
('application', 'qa', 'latest', 'env.name.full', 'Quality'),
('application', 'qa', 'latest', 'env.name.short', 'QA'),
('application', 'prod', 'latest', 'env.name.full', 'Production'),
('application', 'prod', 'latest', 'env.name.short', 'PROD'),

-- Client - 1
('spring-cloud-config-client', 'default', 'latest', 'env.name.full', 'Default - C1'),
('spring-cloud-config-client', 'default', 'latest', 'env.name.short', 'DEF - C1'),
('spring-cloud-config-client', 'dev', 'latest', 'env.name.full', 'Development - C1'),
('spring-cloud-config-client', 'dev', 'latest', 'env.name.short', 'DEV - C1'),
('spring-cloud-config-client', 'qa', 'latest', 'env.name.full', 'Quality - C1'),
('spring-cloud-config-client', 'qa', 'latest', 'env.name.short', 'QA - C1'),
('spring-cloud-config-client', 'prod', 'latest', 'env.name.full', 'Production - C1'),
('spring-cloud-config-client', 'prod', 'latest', 'env.name.short', 'PROD - C1'),

-- Client - 2
('XYZ', 'default', 'latest', 'env.name.full', 'Default - C2'),
('XYZ', 'default', 'latest', 'env.name.short', 'DEF - C2'),
('XYZ', 'dev', 'latest', 'env.name.full', 'Development - C2'),
('XYZ', 'dev', 'latest', 'env.name.short', 'DEV - C2'),
('XYZ', 'qa', 'latest', 'env.name.full', 'Quality - C2'),
('XYZ', 'qa', 'latest', 'env.name.short', 'QA - C2')
-- ('XYZ', 'prod', 'latest', 'env.name.full', 'Production - C2'),
-- ('XYZ', 'prod', 'latest', 'env.name.short', 'PROD - C2')
GO