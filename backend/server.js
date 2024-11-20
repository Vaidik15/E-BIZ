//Import express
const express =require("express");

//Create an express app
const app = express();

//Middleware to parse JSON
app.use(express.json());

//Basic route
app.get("/",(req, res) => {
    res.send("Hello, World! yess");
});

//start the server
const PORT = 5000;
app.listen(PORT, () => {
    console.log('Server is running on http://localhost:${PORT}');
});