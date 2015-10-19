(function(){
    angular.module('boulimiqueLitteraire').factory('BookCommentFactory', ['$http', function ($http) {

        var urlBase = '/api/bookComments';
        var factory = {};

        factory.getAll = function () {
            return $http.get(urlBase)
            .then(function (results){
                return results.data;
            });
        };

        factory.getById = function (id) {
            return $http.get(urlBase + '/' + id).
                then(function (result){
                    return result.data;
                }
            );
        }

        factory.save = function (bookComment) {
            return $http.post(urlBase, bookComment).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.update = function (bookComment) {
            return $http.put(urlBase + '/' + bookComment.id, bookComment).
                then(function(response) {
                    return response.data;
                }
            );
        }

        factory.remove = function (id) {
            return $http.delete(urlBase + '/' + id);
        }

        return factory;
    }]);
}());