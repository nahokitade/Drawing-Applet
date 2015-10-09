require 'spec_helper'

describe StaticPagesController do

  describe "GET 'about'" do
    it "returns http success" do
      get 'about'
      response.should be_success
    end
  end

  describe "GET 'projects'" do
    it "returns http success" do
      get 'projects'
      response.should be_success
    end
  end

  describe "GET 'resume'" do
    it "returns http success" do
      get 'resume'
      response.should be_success
    end
  end

end
