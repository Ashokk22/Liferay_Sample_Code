create table warrior_EntityManager (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	entityAddDate VARCHAR(75) null,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	entitystatus INTEGER,
	companyId LONG,
	groupId LONG,
	userId LONG,
	vocubalaryId LONG,
	categoryId LONG
);