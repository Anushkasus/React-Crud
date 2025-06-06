const sql=require('mssql');

const config={
     user: 'sa',
  password: 'It&24!B&D25',
  server: '192.168.18.30',
  port: 1731,
  database: 'CRUD_Ops',
  options: {
    encrypt: false,
    trustServerCertificate: true
  }
};

module.exports={sql,config};