CREATE KEYSPACE outsiders_arena WITH REPLICATION = {
    'class':'SimpleStrategy',
	'replication_factor':1
};

CREATE TYPE outsiders_arena.effect (
    duration int,
    name text,
    interruptable boolean,
    physical boolean,
    magical boolean,
    statmods map<text, int>
    qualitymods map<text, boolean>
);

CREATE TYPE outsiders_arena.characterinstance (
    hp int,
    playeronecharacter boolean,
    characterid int,
    dead boolean,
    highlighted boolean,
    effects list<frozen<effect>>
);

CREATE TYPE outsiders_arena.ability (
    cooldown int,
    name text,
    aoe boolean,
    self boolean,
    ally boolean,
    enemy boolean,
    cost list<text>,
    selfeffects list<frozen<effect>>,
    enemyeffects list<frozen<effect>>,
    aoeenemyeffects list<frozen<effect>>,
    allyeffects list<frozen<effect>>,
    aoeallyeffects list<frozen<effect>>
);

CREATE TABLE outsiders_arena.battle (
	id int PRIMARY KEY,
    playeronestart boolean,
    status text,
    arenaid int,
    playeridone int,
    playeridtwo int,
    playeroneteam list<frozen<characterinstance>>;
    playertwoteam list<frozen<characterinstance>>;
    playeroneenergy list<text>;
    playertwoenergy list<text>;
);


CREATE TABLE outsiders_arena.character (
    id int PRIMARY KEY,
    avatarurl text,
    name text,
    slot1 frozen<ability>,
    slot2 frozen<ability>,
    slot3 frozen<ability>,
    slot4 frozen<ability>,
    slota frozen<ability>,
    slotb frozen<ability>,
    slotc frozen<ability>,
    slotd frozen<ability>
);

CREATE TABLE outsiders_arena.player (
	id int PRIMARY KEY,
    displayname text,
    avatarurl text,
    currentarena int,
    level int
);