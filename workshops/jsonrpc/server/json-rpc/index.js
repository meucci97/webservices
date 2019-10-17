const express = require('express');
const jsonRouter = require('express-json-rpc-router')
const cors = require('cors');
const app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(cors());
app.use(express.urlencoded({ extended: true }));

const HOUSES = [
  {
    Id: 1,
    Name: "House Algood",
    Region: "The Westerlands",
    CoatOfArms: "A golden wreath, on a blue field with a gold border(Azure, a garland of laurel within a bordure or)",
    Words: "",
  },
  {
    Id: 2,
    Name: "House Allyrion of Godsgrace",
    Region: "Dorne",
    CoatOfArms: "Gyronny Gules and Sable, a hand couped Or",
    Words: "No Foe May Pass",
  },
  {
    Id: 3,
    Name: "House Amber",
    Region: "The North",
    CoatOfArms: "",
    Words: "",
  }];

const controller = {
  'house.GetHouse'({ params }) {
    console.log('id: ', params.Id)
    return HOUSES.find(el => el.Id == params.Id)
  },
  'house.GetHouses'({ params }) {
    console.log('id: ', params.Id)
    return HOUSES
  }
}

// ROUTER
app.use(jsonRouter({ methods: controller }))
app.listen(1234, () => console.log('Example app listening on port 1234'))

module.exports = app;
