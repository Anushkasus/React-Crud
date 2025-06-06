// const express = require('express');
// const sql = require('mssql');
// const cors = require('cors');
// const bodyParser = require('body-parser');

// const app = express();
// const port = 3000;

// // Middleware
// app.use(cors());
// app.use(bodyParser.json());

// // Database configuration                                                                                                                                                                                               

// // GET all items
// app.get('/api/items', async (req, res) => {
//     try {
//       await sql.connect(dbConfig);
//       const result = await sql.query('SELECT * FROM Items');
//       res.json(result.recordset);
//     } catch (err) {
//       console.error('GET /api/items error:', err.stack || err);
//       res.status(500).json({ error: err.message });
//     }
// });
  
// // POST a new item
// app.post('/api/items', async (req, res) => {
//   const { name, description, password } = req.body;

//   try {
//     await sql.connect(dbConfig);
//     const request = new sql.Request();
//     request.input('name', sql.NVarChar, name);
//     request.input('description', sql.NVarChar, description);
//     request.input('password', sql.NVarChar, password);

//     await request.query(`
//       INSERT INTO Items (name, description, password)
//       VALUES (@name, @description, @password)
//     `);

//     res.status(201).json({ message: 'Item Created' });
//   } catch (err) {
//     console.error('POST error:', err);
//     res.status(500).json({ error: 'Insert failed' });
//   }
// });

// // DELETE an item by ID
// app.delete('/api/items/:id', async (req, res) => {
//   const id = req.params.id;

//   try {
//     await sql.connect(dbConfig);
//     const request = new sql.Request();
//     request.input('id', sql.Int, id);

//     await request.query('DELETE FROM Items WHERE id = @id');

//     res.json({ message: 'Item Deleted' });
//   } catch (err) {
//     console.error('DELETE error:', err);
//     res.status(500).json({ error: 'Delete failed' });
//   }
// });

// // PUT (update) an item
// app.put('/api/items/:id', async (req, res) => {
//   const id = req.params.id;
//   const { name, description, password } = req.body;

//   try {
//     await sql.connect(dbConfig);
//     const request = new sql.Request();
//     request.input('id', sql.Int, id);
//     request.input('name', sql.NVarChar, name);
//     request.input('description', sql.NVarChar, description);
//     request.input('password', sql.NVarChar, password);

//     await request.query(`
//       UPDATE Items
//       SET name = @name,
//           description = @description,
//           password = @password
//       WHERE id = @id
//     `);

//     res.json({ message: 'Item Updated' });
//   } catch (err) {
//     console.error('PUT error:', err);
//     res.status(500).json({ error: 'Update failed' });
//   }
// });

// app.listen(port, () => {
//   console.log(`Server running at http://localhost:${port}`);
// });






const express = require('express');
const cors = require('cors');
const sql = require('mssql');
const bodyParser = require('body-parser');
const { config } = require('./db');

const app = express();
app.use(cors());
app.use(bodyParser.json());

// GET ALL items
app.get('/api/items', async (req, res) => {
    try {
        const pool = await sql.connect(config);
        // const result = await pool.request().query('SELECT * FROM items');
        const result = await sql.query('SELECT id, name, description, password FROM Items');
        res.json(result.recordset);
    } catch (err) {
        res.status(500).send(err.message);
    }
});

// CREATE NEW ITEM
app.post('/api/items', async (req, res) => {
    const { name, description, password } = req.body;
    try {
        const pool = await sql.connect(config);
        await pool.request()
            .input('Name', sql.NVarChar, name)
            .input('Description', sql.NVarChar, description)
            .input('Password', sql.NVarChar, password)
            .query('INSERT INTO items (Name, Description, Password) VALUES (@Name, @Description, @Password)');
        
            res.status(201).json({ message: 'Item Created' });
    } catch (err) {
        res.status(500).send(err.message);
    }
});

// UPDATE ITEM
app.put('/api/items/:id', async (req, res) => {
    const { name, description, password } = req.body;
    const id = req.params.id;

    try {
        const pool = await sql.connect(config);
        await pool.request()
            .input('Id', sql.Int, id)
            .input('Name', sql.NVarChar, name)
            .input('Description', sql.NVarChar, description)
            .input('Password', sql.NVarChar, password)
            .query('UPDATE items SET Name=@Name, Description=@Description, Password=@Password WHERE Id=@Id');
            res.json({ message: "Item updated" });
    } catch (err) {
        res.status(500).send(err.message);
    }
});

// DELETE ITEM
app.delete('/api/items/:id', async (req, res) => {
    const id = req.params.id;

    try {
        const pool = await sql.connect(config);
        await pool.request()
            .input('Id', sql.Int, id)
            .query('DELETE FROM items WHERE Id=@Id');
            res.json({ message: "Item deleted" });
    } catch (err) {
        res.status(500).send(err.message);
    }
});

app.listen(3000, () => console.log('Server started on port 3000'));