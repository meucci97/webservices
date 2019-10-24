package main

import (
	"log"
	"net"
	"net/http"
	"net/rpc"
)

type HouseDAO struct {
	Id         int
	Name       string
	Region     string
	CoatOfArms string
	Words      string
}

var houses = []HouseDAO{
	HouseDAO{
		Id:         1,
		Name:       "House Algood",
		Region:     "The Westerlands",
		CoatOfArms: "A golden wreath, on a blue field with a gold border(Azure, a garland of laurel within a bordure or)",
		Words:      "",
	},
	HouseDAO{
		Id:         2,
		Name:       "House Allyrion of Godsgrace",
		Region:     "Dorne",
		CoatOfArms: "Gyronny Gules and Sable, a hand couped Or",
		Words:      "No Foe May Pass",
	},
	HouseDAO{
		Id:         3,
		Name:       "House Amber",
		Region:     "The North",
		CoatOfArms: "",
		Words:      "",
	},
}

type Args struct {
	Id int
}

type House int

func (t *House) GetHouse(args *Args, reply *HouseDAO) error {
	*reply = houses[args.Id]
	return nil
}

func main() {
	/**
	    TO DO
		**/
	house := new(House)
	err := rpc.Register(house)

	if err != nil {
		log.Fatalf("ERROR --> %s", err)
	}

	rpc.HandleHTTP()

	l, e := net.Listen("tcp", ":1234")

	if e != nil {
		log.Fatalf("Couldn't start listening on port 1234. Error %s", e)
	}

	err = http.Serve(l, nil)
	if err != nil {
		log.Fatalf("Error serving: %s", err)
	}
}
