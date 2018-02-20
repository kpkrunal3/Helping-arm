var $products,
	$current_product = 'bucketadmin';

// List all the products here

$products = {
    cvx : {
            name     : 'CVX-WP',
            tag      : 'WP',
            img      : 'https://0.s3.envato.com/files/120552237/screenshots/01_cvx-wp-preview.__large_preview.jpg',
            url      : 'http://cvx.themebucket.biz/',
            purchase : 'http://themeforest.net/item/cvx-resume-and-portfolio-wordpress-theme/9996119?ref=themebucket',
            responsive: 1
    },
    portex : {
            name     : 'PORTEX',
            tag      : 'WP',
            img      : 'https://0.s3.envato.com/files/120437579/screenshots/01_portex_preview.__large_preview.jpg',
            url      : 'http://portexwp.themebucket.net/',
            purchase : 'http://themeforest.net/item/portex-photography-portfolio-wordpress-theme/9487334?ref=themebucket',
            responsive: 1
    },
    cvxhtml : {
            name     : 'CVX',
            tag      : 'HTML',
            img      : 'https://0.s3.envato.com/files/112417119/screenshots/01_cvx-preview.__large_preview.jpg',
            url      : 'http://cvx.markup.themebucket.net/',
            purchase : 'http://themeforest.net/item/cvx-advanced-resume-and-portfolio-html-template/9521475?ref=themebucket',
            responsive: 1
    },
    blogex : {
            name     : 'Blogex',
            tag      : 'WP',
            img      : 'https://0.s3.envato.com/files/107228151/screenshots/01_blogex_preview.__large_preview.jpg',
            url      : 'http://blogex.themebucket.biz/',
            purchase : 'http://themeforest.net/item/blogex-minimal-responsive-wordpress-blog-theme/9067107?ref=themebucket',
            responsive: 1
    },
    uranus : {
            name     : 'Uranus',
            tag      : 'WP',
            img      : 'https://0.s3.envato.com/files/99833054/screenshots/01_uranus_preview.__large_preview.png',
            url      : 'http://uranuswp.themebucket.biz/',
            purchase : 'http://themeforest.net/item/uranus-responsive-multipurpose-wordpress-theme/8373847?ref=themebucket',
            responsive: 0
    },
    adminx : {
            name     : 'AdminX',
            tag      : 'Admin',
            img      : 'https://d2mdw063ttlqtq.cloudfront.net/files/87880892/screenshots/01_adminex_preview.__large_preview.jpg',
            url      : 'http://adminex.themebucket.net/',
            purchase : 'http://themeforest.net/item/adminex-bootstrap-3-responsive-admin-template/7399319?ref=themebucket',
            responsive: 0
    },
    
    firebrick : {
            name     : 'FireBrick',
            tag      : 'WP',
            img      : 'https://d2mdw063ttlqtq.cloudfront.net/files/85917358/screenshots/01_firebrick_preview.__large_preview.jpg',
            url      : 'http://firebrick.themebucket.net/',
            purchase : 'http://themeforest.net/item/firebrick-multipurpose-one-page-wordpress-theme/7227887?ref=themebucket',
            responsive: 0
    },
    resumex : {
        name     : 'ResumeX',
        tag      : 'WP',
        img      : 'http://2.s3.envato.com/files/83660455/screenshots/01_resumex_preview.__large_preview.jpg',
        url      : 'http://resumex.themebucket.net/',
        purchase : 'http://themeforest.net/item/resumex-multipurpose-resume-one-page-portfolio/7044501?ref=themebucket',
        responsive: 0
    },

    supportx : {
        name     : 'SupportX',
        tag      : 'WP',
        img      : 'http://0.s3.envato.com/files/81617229/screenshots/01_supportx_preview.__large_preview.jpg',
        url      : 'http://supportx.themebucket.net/',
        purchase : 'http://themeforest.net/item/supportx-envato-api-enabled-support-forum/6524882?ref=themebucket',
        tooltip  : 'The #1 Support Application for Envato Marketplace Authors',
        responsive: 0

    },

	bucketadmin : {
		name     : 'BucketAdmin',
		tag      : 'admin',
		img      : 'http://2.s3.envato.com/files/80044109/screenshots/01_bucketmin_preview-1.3.__large_preview.jpg',
		url      : 'http://bucketadmin.themebucket.net/',
		purchase : 'http://themeforest.net/item/bucket-admin-bootstrap-3-responsive-flat-dashboard/6642985?ref=themebucket',
		tooltip  : 'The #1 Admin Template',
        responsive: 0
    },

    

	sonnet_wp : {
		name     : 'SonnetWP',
		tag      : 'WP',
		img      : 'http://0.s3.envato.com/files/75171654/screenshots/01_sonnet_preview_wp_1.4.__large_preview.jpg',
		url      : 'http://sonnetwp.themebucket.net/',
		purchase : 'http://themeforest.net/item/sonnet-one-page-wordpress-multipurpose-portfolio/6171819?ref=themebucket',
		responsive: 0
	},

	sonnet : {
		name     : 'Sonnet HTML',
		tag      : 'HTML',
		img      : 'http://3.s3.envato.com/files/71717267/Sonnet%20Preview%20Files/01_sonnet_preview.__large_preview.jpg',
		url      : 'http://sonnet.themebucket.net/',
		purchase : 'http://themeforest.net/item/sonnet-one-page-parallax-multipurpose-portfolio/5907858?ref=themebucket',
        responsive: 0
    },

	artpress : {
		name     : 'ArtPress',
		tag      : 'HTML',
		img      : 'http://2.s3.envato.com/files/66699433/screenshots/01_Artpress-one-page-creative-portfolio.__large_preview.jpg',
		url      : 'http://artpress.themebucket.net/',
		purchase : 'http://themeforest.net/item/artpress-one-page-responsive-creative-portfolio/5548939?ref=themebucket',
        responsive: 0

    }

	
};
