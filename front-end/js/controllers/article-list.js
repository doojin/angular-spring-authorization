function ArticleListController($scope) {
    $scope.articles = [];

    $scope.articles.push({
        title: 'Photographer Ami Vitale\'s Favorite Places to Photograph',
        text: 'In northern Kenya, at the Lewa Wildlife Conservancy, once warring tribes are working together to ' +
        'protect critically endangered animals with dramatically positive results. Here, rhino keeper Kamara ' +
        'hand-raises Kilifi, an 18-month-old rhino, along with two other baby rhinos...',
        author: 'dmitry.papka@gmail.com',
        date: '2d. ago'
    });

    $scope.articles.push({
        title: 'Baby Elephant\'s Death a Grim Reminder of Lack of Wilderness',
        text: 'A three-year-old Asian elephant made a tragic mistake. Last month it strayed onto a farm Tamil Nadu, ' +
        'a state in southern India, chewed on a firecracker that exploded, and later died from its injuries, ' +
        'reports The Indian Express...',
        author: 'dmitry.papka@gmail.com',
        date: '2d. ago'
    });

    $scope.articles.push({
        title: 'What a Comedian Learned by Traveling to the End of the Earth',
        text: 'When he isn\'t writing scripts for TV shows such as American Dad!, The Office, or Late Show with ' +
        'David Letterman, Steve Hely likes to spin a bottle on a map and have it point him in the direction of ' +
        'somewhere he has never been before...',
        author: 'dmitry.papka@gmail.com',
        date: '2d. ago'
    });

    $scope.articles.push({
        title: 'Watch: Pooping Comb Jellies Just Upended Gut Evolution',
        text: 'There\'s an origin story about butts: Once upon a time, all animals were essentially blobs with ' +
        'mouths, and they had to eat and defecate through that single hole. But over the millennia, some blobs ' +
        'straightened out and gave way to animals with heads to ingest food on one end, anuses to defecate at the ' +
        'other, and guts in between...',
        author: 'dmitry.papka@gmail.com',
        date: '2d. ago'
    });
}

export default ArticleListController;