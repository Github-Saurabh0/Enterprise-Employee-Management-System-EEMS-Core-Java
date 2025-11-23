
# Enterprise Employee Management System (EEMS) - Core Java

Project: Enterprise Employee Management System (EEMS)
Stack: Core Java (no frameworks), Java Collections, File I/O, Multithreading, Design Patterns
Duration: 10-day guided build (Day 1 -> Day 10) with commit-style history and starter code.

What is included in this repo (zip)
- README.md (this file) - project overview, installation, and 10-day plan
- src/ - starter Java source files (model, service, dao, utils, exceptions, App.java)
- days/ - day1..day10 task notes and objectives (text files)
- commits.txt - simulated git commit messages for each day and file changes
- docs/ - HLD.md and LLD.md skeletons (design docs)

Quick setup (for local Java dev)
1. Unzip the repository.
2. Compile: javac -d out src/**/*.java
3. Run: java -cp out app.App
   - (Note: simple file-based persistence; no DB configured. This is a starter skeleton.)

10-Day Plan Summary
- Day 1 - Project scaffolding, models (Employee), basic DAO (file-based), README
- Day 2 - Employee CRUD, EmployeeService, unit-runner app menu
- Day 3 - Authentication, Password hashing, Logger util
- Day 4 - Leave management + custom exceptions
- Day 5 - Payroll engine: FullTime/PartTime polymorphism
- Day 6 - Reporting: CSV/JSON export + ReportScheduler (ExecutorService)
- Day 7 - Serialization, persistence improvements, data migration script
- Day 8 - Advanced search & sorting (Comparator), pagination helper
- Day 9 - Input validation, custom exceptions, robust error handling, logging
- Day 10 - Final polish: README, HLD/LLD, demo data, commits, zip

Notes
- This repo is intended as an industry-level core Java learning project and resume/demo piece.
- You can extend it with JDBC integration, REST wrapper, or a simple Swing/JavaFX GUI in future iterations.

#

Repo Structure:

- README.md
- /src
  - /model
    - Employee.java
  - /service
    - EmployeeService.java
  - /dao
    - EmployeeDao.java
  - /utils
    - LoggerUtil.java
  - App.java
- /days
  - day1.txt
  - day2.txt


##  Contact & Support

 Developed by [Wearl Technologies](https://wearl.co.in)  
 Email: [hello@wearl.co.in](mailto:hello@wearl.co.in)  
 Website: [https://wearl.co.in](https://wearl.co.in)  
 Instagram: [@dev.wearl](https://instagram.com/dev.wearl)

---

## License

This project is licensed under the GNU General Public License v2 (GPL2).
You are free to modify and redistribute this software under the same license.

---

## Contributing

Contributions, issues, and feature requests are welcome!
1. Fork this repo
2. Create a new branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -m "Added new feature"`
4. Push and open a Pull Request

---

## About Wearl Technologies

Wearl Technologies is a digital innovation company specializing in:
 • Web Development
 • E-commerce Solutions
 • Mobile App Development
 • AI Integrations

We help businesses go digital and scale faster through custom-built tech solutions.

Visit wearl.co.in → (https://wearl.co.in)

---

© 2025 [Wearl Technologies](https://wearl.co.in) – All Rights Reserved.