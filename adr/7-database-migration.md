# 7. Database Migration Framework

Date: 2021-11-05

## Status

Rejected

## Context

For keeping the database consistent, it should be gradually changed through a migrations framework

## Decision

As of now, the project is simple enough, and the database structure is simple enough to not utilize this, for the sake
of time constraints.

## Consequences

No database migration framework is introduced. The database is used as is, and is recreated from scratch at every
startup.
