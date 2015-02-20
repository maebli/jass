# jass

OOP described in words.

Objets are Headings and italics. Primitive-types and Enums are bold.

# Highest Level Of Abstraction :A CardGame

### CardGame
A *CardGame* has a **Name**, a *RuleSet*, a *PlayerSet*, a *TeamSet*, a *CardDeck*, a *GameModerator*, a *Table* and a *MoveMomento*. 

### Game Moderator
A *GameModerator* interacts with *MoveScheduler*, *StatisticsKeeper*, *Umpire*, *Player*s and *Team*s. *GameModerator* demands *Players* and *Teams* to make *Move*s.  *Moves* are returned by *Players* and *Teams*. *GameModerator* demands *Scheduler* to determine who's next to make a *Move* according to the last *Move* made. *GameModerator* demands *StatisticsKeeper* to log a *Move* that was made, to report *GameStatistics*. *GameModerator* asks the *Umpire* if a *Move* complies with the *RuleSet*.

A *GameModerator* shuffles and deals the *CardDeck* before the the Game starts.  


### RuleSet
A *RuleSet* is is nonmutable and defined before a *CardGame* starts.

### Table
A *Table* has a *CardSpotSet*.

### CardSpot
*Player*s can view, put and take *Cards* from a *CardSpot*. A *CardSpot* has a **Name** and a *CardSpotBehavior*.
	

### Card
A *Card* has a **Color** and an **Number** .

### Hand

A Hand is a *CardSet* of a *Player*.

### Player
A *Player* has a **Name**. A *Player* can make *Moves*.

# Second Level Of Abstraction: A Jass
A *Jass* is a *CardGame* with the name **Jass**. 
A *Jass* has four *Players*.

### JassRuleSet

The *JassRuleSet* is the core *RuleSet* for all *Jass*es. 

### JassCard
A *JassCard* is a Card.
A *JassCard* has a **Vaue*.

### JassCardColor

### JassCardValue

### JassPlayer
A *JassPlayer* has a *JassHand*.

### JassHand
A *JassHand* has seven or less JassCards.


# Third Level Of Abstraction: The SchieberJass

A *SchieberJass* is a Jass.
The *RuleSet* of a *SchieberJass* is the *SchieberJassRuleSet*.
 