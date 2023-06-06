# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)

Player.delete_all

Player.create!(full_name: "Kevin Durant", position: "F", sps: 15, shot_perc: 44)
Player.create!(full_name: "Stephen Curry", position: "G", sps: 14, shot_perc: 48)
Player.create!(full_name: "LeBron James", position: "F", sps: 13, shot_perc: 42)
Player.create!(full_name: "Joel Embild", position: "C", sps: 10, shot_perc: 41)
Player.create!(full_name: "Kawhi Leonard", position: "F", sps: 13, shot_perc: 44)
Player.create!(full_name: "DeMarcus Cousins", position: "C", sps: 9, shot_perc: 34)
Player.create!(full_name: "Anthony Davis", position: "C", sps: 14, shot_perc: 47)
Player.create!(full_name: "James Harden", position: "G", sps: 14, shot_perc: 48)
Player.create!(full_name: "Russell Westbrook", position: "G", sps: 15, shot_perc: 46)
Player.create!(full_name: "Giannis Antetokounmpo", position: "F", sps: 14, shot_perc: 43)
Player.create!(full_name: "Karl Anthony Towns", position: "C", sps: 13, shot_perc: 40)
Player.create!(full_name: "Paul George", position: "G", sps: 12, shot_perc: 42)
Player.create!(full_name: "Nikola Jokic", position: "C", sps: 11, shot_perc: 41)
Player.create!(full_name: "Bradley Beal", position: "G", sps: 10, shot_perc: 39)
Player.create!(full_name: "Derek Favors", position: "C", sps: 9, shot_perc: 32)
