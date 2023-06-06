# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2019_08_02_172326) do

  create_table "contact_requests", force: :cascade do |t|
    t.integer "user_id"
    t.string "body"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "games", force: :cascade do |t|
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "gamez", force: :cascade do |t|
    t.integer "user_id1"
    t.integer "user_id2"
    t.integer "u1p1_id"
    t.integer "u1p2_id"
    t.integer "u1p3_id"
    t.integer "u1p4_id"
    t.integer "u1p5_id"
    t.integer "u2p1_id"
    t.integer "u2p2_id"
    t.integer "u2p3_id"
    t.integer "u2p4_id"
    t.integer "u2p5_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "players", force: :cascade do |t|
    t.string "full_name"
    t.string "position"
    t.integer "sps"
    t.integer "shot_perc"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "simgames", force: :cascade do |t|
    t.integer "user_id1"
    t.integer "user_id2"
    t.integer "u1p1_id"
    t.integer "u1p2_id"
    t.integer "u1p3_id"
    t.integer "u1p4_id"
    t.integer "u1p5_id"
    t.integer "u2p1_id"
    t.integer "u2p2_id"
    t.integer "u2p3_id"
    t.integer "u2p4_id"
    t.integer "u2p5_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "users", force: :cascade do |t|
    t.string "full_name"
    t.string "username"
    t.string "team_name"
    t.string "password_digest"
    t.string "email"
    t.integer "amount"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

end
