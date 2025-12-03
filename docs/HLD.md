
# High Level Design (HLD) – EEMS

## 1. Architecture Overview
A layered, modular architecture:

App (CLI)
   ↓
Services (Business Logic)
   ↓
DAO Layer (File-based persistence)
   ↓
Storage (CSV + Serialized Data)

## 2. Major Modules

✔ Employee Module  
✔ Leave Module  
✔ Payroll Module  
✔ Reporting Module  
✔ Validation Module  
✔ Utilities  

## 3. Data Flow
App → Service → DAO → File  
App → Reporting Service → CSV File  

## 4. Concurrency
- ExecutorService for background scheduled reporting  

## 5. Non-functional Requirements
- Maintainability  
- Modularity  
- Efficiency  
- Reliability  
- Low memory footprint using pure Java  
