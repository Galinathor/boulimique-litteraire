(function () {
    angular.module('boulimiqueLitteraire').
        controller('BooksCtrl', ['$scope', 'BookFactory',
        function ($scope, BookFactory) {

        $scope.books = [];
        $scope.currentPage = 1;
        $scope.itemsPerPage = 3;
        $scope.maxSize = 5;

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        function sortBooks(){
            $scope.books.sort(function (a, b) {
                if (a.creationDate > b.creationDate)
                    return -1;
                if (a.creationDate < b.creationDate)
                    return 1;
                return 0;
            });
        }

        function init() {
            BookFactory.getAll().
            then(function(data){
                $scope.books = data;
                sortBooks();
            }, function(error){
                console.log(error.data.message);
            })
        }
        init();
    }]);
}());