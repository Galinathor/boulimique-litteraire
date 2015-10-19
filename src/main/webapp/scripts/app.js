(function () {
    var app = angular.module('boulimiqueLitteraire', ['ngResource', 'ngSanitize', 'ngRoute', 'ui.bootstrap', 'pickadate',]);

    app.config(function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'HomeCtrl'
            }).when('/books', {
                templateUrl: 'views/books.html',
                controller: 'BooksCtrl'
            }).when('/recipes', {
                templateUrl: 'views/recipes.html',
                controller: 'RecipesCtrl'
            }).when('/book/:id', {
                templateUrl: 'views/book.html',
                controller: 'BookCtrl'
            }).when('/recipe/:id', {
                templateUrl: 'views/recipe.html',
                controller: 'RecipeCtrl'
            }).otherwise({
                redirectTo: '/'
            })
    });
}());