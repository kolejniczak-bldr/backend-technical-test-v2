# 3. Usage of spotless plugin

Date: 2021-11-05

## Status

Accepted

## Context

After decision #2 an executor of the Google Java Format had to be chosen.

## Decision

Choice was [spotless](https://github.com/diffplug/spotless/tree/master/plugin-maven) to be added to verification steps.

## Consequences

`spotless:check` is automatically executed with `maven:verify` goal, effectively making the check be a part of every
build.
