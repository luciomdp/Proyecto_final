# FootballTournamentManager

**FootballTournamentManager** is a Java + Swing application developed as part of the "Programación B" course at university. It simulates and manages the Continental Football League's Annual Championship based on specific competition rules.

## Features

- **Tournament Structure**:  
  16 teams divided into 4 zones of 4. Each team plays 3 matches in its group. The top 2 teams per group qualify for knockout stages (quarterfinals, semifinals, and final).

- **Match Simulation**:  
  Results are generated based on team rankings, average player ratings, manager achievements, and a random component. Knockout matches include 2 legs (except the final) and apply tie-breaking criteria such as away goals and penalty shootouts.

- **Data Management**:  
  Stores and manages detailed information about:
  - Teams: name, country, ranking, roster of 18 players, and coach.
  - Players: full name, birthdate, ID, position, rating.
  - Coaches: nationality, total titles won.
  - Referees: full name, birthdate, ID, nationality, years of experience.

- **Rules & Logic**:
  - Standings in group stage are ordered by points, goal difference, goals scored, and head-to-head.
  - Referees must have different nationality than the teams, unless both teams share the same one.
  - Penalty shootouts resolve ties in final or if tie-breakers fail in knockouts.

- **Reports**:
  - Alphabetical list of teams with player age average, coach info, and performance percentage.
  - Referee ranking by matches officiated, including average years of experience.
  - Player listings by position, including specific stats for goalkeepers.

## Technologies

- Java  
- Swing for GUI  

## Purpose

This project is an academic assignment intended to demonstrate object-oriented programming principles, data handling, GUI design, and rule-based logic implementation in a sports simulation context.
