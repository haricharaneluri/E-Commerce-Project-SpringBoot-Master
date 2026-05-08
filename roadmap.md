# Project Roadmap

This roadmap is the single source of direction for contributors and maintainers.

Purpose:
- Make the project production-minded and contributor-friendly.
- Turn this repository into a practical learning path for real-world backend engineering.

How to use this file:
- Pick tasks marked [good first issue] if you are new.
- Pick [help wanted] for medium complexity.
- Pick [advanced] for architecture-heavy or migration-heavy work.
- Use [discussion] items to propose direction before writing code.

Status model:
- Planned: approved idea, not started.
- In Progress: active work in issues/PRs.
- Completed: merged and documented.

---

## North Star

By the end of this roadmap, this repository should be:
- Easy to run locally in minutes.
- Safe to contribute to without breaking main.
- Structured like a professional Java backend project.
- Feature-complete enough to demonstrate full e-commerce workflows.
- Rich in system design and scalability concepts for learning and interviews.

---

## Guiding Principles

- Keep the current stack direction: Spring Boot + server-rendered views (JSP).
- Prefer incremental modernization over big-bang rewrites.
- Every feature must include test coverage and docs updates.
- Every merge to main should pass CI.
- Optimize for contributor onboarding and maintainability.

---

## What We Will Not Do

- Rewrite to another backend framework (for example Quarkus or Micronaut).
- Replace the current JSP-based UI with a React/Vue rewrite as part of this roadmap.

Reason:
- The goal is to evolve this codebase, not restart from scratch.

---

## Phase 1 - Solid Foundation

Timeline: Current focus (0 to 8 weeks)
Goal: Make this a trustworthy, runnable, and maintainable reference project.

### 1.1 Correctness and Stability

- Triage and close high-impact bugs from open issues and active PRs. [help wanted]
- Standardize error handling for controller and service layers. [help wanted]
- Remove remaining dead code and inconsistent naming in core modules. [help wanted]

### 1.2 Developer Experience and Setup

- Docker Compose local setup (app + MySQL) with one command startup. [help wanted]
- GitHub Actions pipeline running mvn clean verify on every PR. [help wanted]
- Issue templates and pull request template under .github/. [good first issue]
- CONTRIBUTING.md with branch naming, commit conventions, and local run/test commands. [good first issue]
- Add Checkstyle and enforce it in build and CI. [help wanted]
- Add profiles for dev, test, prod with clean configuration split. [help wanted]

### 1.3 Platform Modernization

- Upgrade to Java 17 and Spring Boot 3.x. [advanced]
- Migrate javax.* imports to jakarta.* as required. [help wanted]
- Verify Hibernate, security, and plugin compatibility post-migration. [advanced]

### 1.4 Testing and Quality Gates

- Unit tests for all service classes using JUnit 5 + Mockito. [good first issue]
- Controller integration tests using @WebMvcTest. [help wanted]
- Add JaCoCo report and README coverage badge. [good first issue]
- DAO tests with Testcontainers MySQL for CI portability. [advanced]

### 1.5 Phase 1 Definition of Done

- New contributor can run app locally with docs and docker-compose.
- Every PR executes automated build and test checks.
- Main branch remains green for 30 consecutive days.
- Core modules have meaningful baseline unit/integration coverage.

---

## Phase 2 - Complete E-Commerce Domain

Timeline: After Phase 1 is stable (8 to 16 weeks)
Goal: Move from a skeleton to a complete and coherent e-commerce flow.

### 2.1 Cart and Checkout

- Complete cart lifecycle (add, update, remove, clear). [help wanted]
- Implement checkout flow with order placement and confirmation. [advanced]
- Introduce order states (created, paid, failed, shipped, delivered, canceled). [help wanted]

### 2.2 Architecture Improvements

- Global exception handler for API and controller exceptions. [help wanted]
- Pagination and sorting for product and customer listings. [good first issue]
- Database migrations with Flyway. [help wanted]
- Structured logging with SLF4J and consistent log levels. [help wanted]

### 2.3 Product Enhancements

- Real image upload (multipart) with local storage abstraction and cloud-ready design. [advanced]
- Product search by name and category (DB-level first). [good first issue]
- Stock status and disabled add-to-cart for quantity 0. [good first issue]

### 2.4 User and Security Enhancements

- Password reset with time-bound token. [advanced]
- Email verification on registration. [advanced]
- Remember-me login support. [help wanted]
- Multiple addresses per user and delivery selection. [help wanted]

### 2.5 API Documentation

- OpenAPI 3 / Swagger UI integration and endpoint docs generation. [good first issue]

### 2.6 Phase 2 Definition of Done

- End-to-end purchase flow works from product browse to order creation.
- Error handling and pagination are implemented in major flows.
- Migrations are source-controlled and repeatable.

---

## Phase 3 - Industry Standards and Scalability Patterns

Timeline: After Phase 2 feature completeness (16 to 28 weeks)
Goal: Teach production-grade concepts used in large-scale Java systems.

### 3.1 Performance and Caching

- Add key DB indexes and document query plans for hot paths. [help wanted]
- Introduce Redis caching for read-heavy endpoints. [advanced]
- Tune connection pool and benchmark critical endpoints. [help wanted]

### 3.2 Concurrency Control

- Optimistic locking for inventory update races. [advanced]
- Pessimistic locking demo and tradeoff documentation. [advanced]

### 3.3 Search and Filtering

- Integrate Elasticsearch for full-text product search. [advanced]
- Keep SQL search as fallback mode for local environments. [help wanted]

### 3.4 Probabilistic Filtering

- Bloom filter for fast existence pre-checks (user/product scenarios). [advanced]
- Document false-positive tradeoffs and where not to use it. [discussion]

### 3.5 Design Patterns in Real Features

- Strategy pattern for payment options (COD, mock card, mock UPI). [advanced]
- Factory pattern for discount and coupon calculations. [advanced]

### 3.6 Observability and Operations

- Spring Boot Actuator endpoints (health, metrics, info). [good first issue]
- Prometheus + Grafana setup with docker-compose profile and sample dashboard. [advanced]
- JSON structured logging with Logback. [help wanted]

### 3.7 Phase 3 Definition of Done

- At least one documented concurrency strategy in inventory path.
- Search supports both database fallback and Elasticsearch mode.
- Operational metrics are available and graphable.

---

## Phase 4 - Microservices and System Design Evolution

Timeline: Long-term and community-driven (28+ weeks)
Goal: Explain and prototype decomposition paths without breaking the monolith learning path.

### 4.1 Service Decomposition Guide

- Write a decomposition plan for user, product, order, notification services. [discussion]
- Document tradeoffs between monolith and microservices. [discussion]

### 4.2 Event-Driven Flows

- Introduce Kafka-based order events and subscribers. [advanced]
- Demonstrate eventual consistency and retry patterns. [advanced]

### 4.3 Phase 4 Definition of Done

- Architecture docs clearly show boundaries and communication patterns.
- At least one event-driven business workflow is implemented and tested.

---

## Maintenance and Governance Track (Runs Across All Phases)

This is always active and should not wait for feature phases.

### Automation

- Dependabot for pom.xml dependency updates. [good first issue]
- Stale bot for inactive issues and PRs with clear messaging. [good first issue]
- Checkstyle gate in CI for all PRs. [help wanted]
- PR size labeler (size/S, size/M, size/L). [good first issue]

### Documentation

- docs/adr/ for architecture decision records. [good first issue]
- docs/architecture.md with component diagram (Mermaid preferred). [good first issue]
- SECURITY.md with responsible disclosure process. [good first issue]
- Learning path docs or wiki (DAO -> Service -> Controller -> View). [good first issue]

### Community Operations

- Weekly issue triage and labeling.
- Monthly roadmap check-in and phase status update.
- Contributor spotlight in release notes for merged community PRs.

---

## Suggested Labels

Use these labels consistently on issues:
- roadmap/phase-1
- roadmap/phase-2
- roadmap/phase-3
- roadmap/phase-4
- good first issue
- help wanted
- advanced
- discussion
- blocked
- priority/high
- priority/medium
- priority/low

---

## Contribution Workflow by Role

New contributor:
- Pick any issue labeled good first issue and roadmap/phase-1.
- Open draft PR early and ask for direction.

Regular contributor:
- Pick help wanted items from active phase.
- Include tests, docs, and migration notes in the same PR.

Maintainer:
- Keep issue labels and phase board updated.
- Reject feature PRs that bypass tests or docs.

---

## PR Acceptance Criteria

Every PR should:
- Pass CI build and tests.
- Include tests for behavior changes.
- Keep scope focused (avoid mega PRs).
- Update docs when behavior, setup, or architecture changes.
- Include rollback notes for risky changes.

---

## Star Growth Plan (1k -> 10k)

Technical quality drives stars, but communication multiplies growth.

### Product and Engineering Signals

- Keep main branch stable and green.
- Publish clear release notes for each milestone.
- Maintain a visible public roadmap and status updates.

### Community and Discoverability Signals

- Mark beginner-friendly issues clearly and keep them fresh.
- Add before/after screenshots and architecture diagrams per major phase.
- Promote milestone achievements (for example: Spring Boot 3 migration complete, full checkout complete).

### Metrics to Track Monthly

- Number of contributors and first-time contributors.
- PR lead time and merge rate.
- CI pass rate on PRs.
- Open issues by priority.

---

## Current Active Priorities

Top priorities right now:
1. Docker Compose local setup.
2. GitHub Actions CI for pull requests.
3. CONTRIBUTING.md + issue/PR templates.
4. Baseline tests for services and controllers.
5. Spring Boot 3 / Java 17 migration plan and spike.

If you want to contribute today, start from these five.
