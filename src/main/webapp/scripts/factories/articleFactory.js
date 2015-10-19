(function(){
    angular.module('boulimiqueLitteraire').factory('ArticleFactory', ['$http', function ($http) {

        var urlBase = '/api/articles';
        var factory = {};

        factory.getLastArticles = function () {
            return $http.get(urlBase)
            .then(function (results){
                return results.data;
            });
        };

        return factory;
    }]);
}());