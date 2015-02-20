# jass

OOP described in words.

Objets are Headings and italics. Primitive-types and Enums are bold.

# Highest Level Of Abstraction :A CardGame

### CardGame
A *CardGame* has a **Name**, a *RuleSet*, a *PlayerSet*, a *TeamSet*, a *GameModerator*. 

### Game Moderator
A *GameModerator* interacts with *TurnScheduler*, *StatisticsKeeper*, *Umpire*, *Player*s and *Team*s. *GameModerator* demands *Players* and *Teams* to make a *Move*.  *Moves* are returned by *Players* and *Teams*. *GameModerator* demands *TurnScheduler* to determine who's next to make a *Move* according to the last *Move* made. *GameModerator* demands *StatisticsKeeper* to log a *Move* that was made, to report *GameStatistics*. *GameModerator* asks the *Umpire* if a *Move* complies with the *RuleSet*.

### RuleSet
A *RuleSet* is is nonmutable and defined before a *CardGame* starts.

### Card
A *Card* has a **Color** and an **Number** .

### CardColor

### CardNumber

### Hand

A Hand has no more than 10 *Cards*.


### Player
A *Player* has a **Name** and a **Position**.

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
 