<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IBM Skillsbuild</title>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap');

        :root {
            --background: 222.2 84% 4.9%;
            --foreground: 210 40% 98%;
            --card: 222.2 84% 4.9%;
            --card-foreground: 210 40% 98%;
            --popover: 222.2 84% 4.9%;
            --popover-foreground: 210 40% 98%;
            --primary: 217.2 91.2% 59.8%;
            --primary-foreground: 222.2 47.4% 11.2%;
            --secondary: 217.2 32.6% 17.5%;
            --secondary-foreground: 210 40% 98%;
            --muted: 217.2 32.6% 17.5%;
            --muted-foreground: 215 20.2% 65.1%;
            --accent: 217.2 32.6% 17.5%;
            --accent-foreground: 210 40% 98%;
            --destructive: 0 62.8% 30.6%;
            --destructive-foreground: 210 40% 98%;
            --border: 217.2 32.6% 17.5%;
            --input: 217.2 32.6% 17.5%;
            --ring: 224.3 76.3% 48%;

            --header: 60px;
            --gradient: rgb(15, 15, 53);

        }

        .light {
            --background: 0 0% 100%;
            --foreground: 222.2 84% 4.9%;
            --card: 0 0% 100%;
            --card-foreground: 222.2 84% 4.9%;
            --popover: 0 0% 100%;
            --popover-foreground: 222.2 84% 4.9%;
            --primary: 221.2 83.2% 53.3%;
            --primary-foreground: 210 40% 98%;
            --secondary: 210 40% 96.1%;
            --secondary-foreground: 222.2 47.4% 11.2%;
            --muted: 210 40% 96.1%;
            --muted-foreground: 215.4 16.3% 46.9%;
            --accent: 210 40% 96.1%;
            --accent-foreground: 222.2 47.4% 11.2%;
            --destructive: 0 84.2% 60.2%;
            --destructive-foreground: 210 40% 98%;
            --border: 214.3 31.8% 91.4%;
            --input: 214.3 31.8% 91.4%;
            --ring: 221.2 83.2% 53.3%;
            --radius: 0.5rem;
            --gradient: rgba(98, 98, 197, 0.3)
        }



        body {
            margin: 0;
            padding: 0;
            min-height: 100vh;
            background: -webkit-radial-gradient(bottom left, var(--gradient) 15%, hsl(var(--background)) 60%, hsl(var(--background)) 60%);

            /* color: rgb(15, 15, 53); */
            color: hsl(var(--foreground));
            font-family: "IBM Plex Sans", sans-serif;
        }

        h1 {
            margin: 0;

        }

        header {
            width: 100%;
            height: var(--header);
            border-bottom: 1px solid hsl(var(--border));
            background-color: hsl(var(--background));
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 10%;
            box-sizing: border-box;
        }

        .nav-logo {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }

        .nav-logo h1 {
            margin: 0;
            font-weight: 500;
            font-size: 18px;

        }

        .nav {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .nav div {
            cursor: pointer;
            font-weight: 500;
        }

        .nav ion-icon {
            padding: 0 30px;
            cursor: pointer;
            box-sizing: border-box;
        }

        .nav-btn {
            padding: 0 15px;
            cursor: pointer;
            box-sizing: border-box;
            border-left: 1px solid hsl(var(--border));
            height: var(--header);
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 16px;
            color: inherit;
            text-decoration: none;
        }

        .sign-up {
            background-color: hsl(var(--primary));
            color: hsl(var(--primary-foreground));

            border-right: 1px solid hsl(var(--border));
            border-bottom: 1px solid hsl(var(--border));
        }



        main {
            height: calc(100vh - var(--header));
            width: 100%;

            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            flex-direction: column;
            padding: 0 10%;
            box-sizing: border-box;
        }

        .title {
            width: 50%;
            padding: 50px 0;
            box-sizing: border-box;
            font-size: 38px;
            text-align: left;
        }

        .title text {
            font-size: 34px;
        }
        footer {
            width: 100%;
            position: absolute;
            bottom: 10px;
            padding: 0 10%;
            box-sizing: border-box;
        }

        @media screen and (max-width: 800px) {

            .logo-img {
                width: 24px;
            }

            .nav-logo h1 {
                font-size: 16px;
            }

            .nav-btn {
                font-size: 12px;
                padding: 0 10px;


            }

            .nav ion-icon {
                padding: 0 10px;
                font-size: 16px;
            }

            .title {
                font-size: 28px;
                width: 100%;

            }

            .title text {
                font-size: 24px;

            }

            .card {
                flex: 0 0 50%;

            }

            header {
                padding: 0 5%;
            }

            main {
                padding: 0 5%;
                justify-content: flex-start;
            }

            footer{
                padding: 0 5%;

            }

            :root {
                --header: 40px
            }
        }

        @media screen and (max-width: 400px) {
            header {
                padding: 0 2.5%;
            }

            main {
                padding: 0 2.5%;
            }

            footer{
                padding: 0 2.5%;

            }

        }

        footer a{
            color: inherit;
        }
    </style>
</head>

<body>
<header>
    <div class="nav-logo">
        <img class="logo-img" src="https://skillsbuild.org/favicon-32x32.png" />
        <div>
            <h1>SkillsBuild</h1>
        </div>
    </div>
    <div class="nav">
        <ion-icon class="nav-btn" name="sunny-outline" onclick="toggleRoot()"></ion-icon>

        <a class="nav-btn" href="/">
            Log in
        </a>
        <a class="nav-btn sign-up" href="/register">
            Sign up
        </a>
    </div>
</header>
<main>
    <div class="title">
        <h1>IBM SkillsBuild </h1>
        <text>
            'Power your future in tech with job skills, courses, and credentials for free.'
        </text>
    </div>
</main>
<footer>
    <div>
        General theme is inspired by the <a href="https://skillsbuild.org/">IBM skillsbuild website</a>.

    </div>
</footer>
</body>

</html>
<script>
    function toggleRoot() {
        var root = document.documentElement;
        var currentTheme = localStorage.getItem('theme');

        if (currentTheme === 'light') {
            root.classList.remove('light');
            document.querySelector('ion-icon').setAttribute('name', 'sunny-outline');
            localStorage.setItem('theme', 'dark');
        } else {
            root.classList.add('light');
            document.querySelector('ion-icon').setAttribute('name', 'moon-outline');
            localStorage.setItem('theme', 'light');
        }
    }

    document.addEventListener('DOMContentLoaded', function () {
        var currentTheme = localStorage.getItem('theme');
        if (currentTheme === 'light') {
            document.documentElement.classList.add('light');
            document.querySelector('ion-icon').setAttribute('name', 'moon-outline');
        }
    });
</script>