
# High Level Design (HLD) - EEMS (skeleton)

Goals
- Lightweight, file-based persistence
- Modular layers: model, dao, service, utils, scheduler
- Clear separation of concerns and testability

Components
- App (CLI) -> Services -> DAOs -> File Storage (CSV/JSON/serialized)
- Scheduler for background reports using ExecutorService
