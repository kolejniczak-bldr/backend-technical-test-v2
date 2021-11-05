# 4. In-memory database choice

Date: 2021-11-05

## Status

Accepted

## Context

A requirement for this project is an in-memory database. Additionally, the focus lies on speed of configuration, and the
leverage of already having Spring Boot. This limits the choice to H2, HSQLDB, or Derby.

## Decision

The choice was [HSQLDB](http://hsqldb.org/), as H2 wasn't updated for the past 2 years, and Derby for over a year.
Additionally, it allows for file-based storage, if the in-memory requirement changes, giving us time to set up an
alternative, without compromising stability.

## Consequences

The database used from now on is an **in-memory** HSQLDB. 
