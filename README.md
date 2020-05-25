# Recipe app
Basic app that retrieves and caches recipes results from https://www.themealdb.com/ open source api.

### Objective
The objective of this app is to build a sample app that can be used as a startup reference project for other android projects.

### Design features
1. mvvm
2. repositories
3. basic dependency injection provided by an AppModule
4. ui and network models separation

### Testing features
1. espresso tests for views
2. espresso scenario tests for common user journeys (navigation between different views)
3. robots to reduce duplication of code and improve encapsulation of ui matchers and actions
4. provide TestModule to run espresso tests and not the real AppModule
5. screenshot tests (needs api 26 emulator and pillow installed)
6. unit testing different components
