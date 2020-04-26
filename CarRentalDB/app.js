var express = require('express');
var mysql = require('mysql');
var bodyparser = require('body-parser');

//connection
var con = mysql.createConnection({
	host : 'localhost',
	user : 'root',
	password : '',
	database : 'carrentals'
});

// initialise express
var app = express();
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended:true}));


app.post('/register/',(req,res,next)=>{

	var data = req.body;
	var FirstName = data.FirstName;
	var LastName = data.LastName;
	var Email = data.Email;
	var Password = data.Password;
	var Mobile = data.Mobile;
	

	//Selicting tables from Database
	con.query( 'SELECT * FROM user where Email=?' ,[Email], function(err,result,fields){
			con.on('error',(err)=>{
				//gives error
				console.log('[MySQL ERROR]',err);
			});

			if(result && result.length){
				res.json('User exists !!!');
			}
			else
			{
				//Inserts values into Database
				var sql = "INSERT INTO user (FirstName,LastName,Email,Password,Mobile) VALUES (?,?,?,?,?)";
				var values = [FirstName,LastName,Email,Password,Mobile];

				console.log(sql,values)

				con.query(sql, values ,function(err,result,fields){
					con.on('error',(err)=>{
						console.log('[MySQL ERROR]',err)
					});
					res.json('Register Successful')
					console.log('registered')
				});
			}
		});
});

app.post('/login/',(req,res,next)=>{
	var data = req.body;
	
	var Password = data.Password;
	var Email = data.Email;


	con.query('SELECT * FROM user where Email = ?',[Email],function(err,result,fields){
		con.on('error',(err)=>{
			console.log('[MySQL ERROR]',err);
		});
		
		if(result && result.length){

			if(Password == result[0].Password){
				res.json('Valid user');	
			}else{
				res.json('Invalid user');
			}
		}
	});


});

// start node server
app.listen(8082,() => {
	console.log('server running on : http://localhost:%s',8082);
});