create index IX_7646E4E0 on warrior_EntityManager (categoryId);
create index IX_E4AC7BD5 on warrior_EntityManager (companyId);
create index IX_6185B599 on warrior_EntityManager (description);
create index IX_E38C6169 on warrior_EntityManager (entityAddDate);
create index IX_2855A85 on warrior_EntityManager (entityId);
create index IX_55BF397 on warrior_EntityManager (groupId);
create index IX_B646B5A0 on warrior_EntityManager (groupId, entitystatus);
create index IX_2475D935 on warrior_EntityManager (title);
create index IX_6D377FE1 on warrior_EntityManager (uuid_);
create index IX_BC0F7DA7 on warrior_EntityManager (uuid_, companyId);
create unique index IX_46D941E9 on warrior_EntityManager (uuid_, groupId);
create index IX_9B649688 on warrior_EntityManager (vocubalaryId);