dev:cljs.user=> (com.fulcrologic.fulcro.application/current-state app.application/app)
{:friends [:list/id :friends]
 :enemies [:list/id :enemies]
 :person/id {1 {:person/id 1, :person/name "Sally", :person/age 32}
             2 {:person/id 2, :person/name "Joe", :person/age 22}
             3 {:person/id 3, :person/name "Fred", :person/age 11}
             4 {:person/id 4, :person/name "Bobby", :person/age 55}}
 :list/id {:friends {:list/id :friends, :list/label "Friends", :list/people [[:person/id 1] [:person/id 2]]}
           :enemies {:list/id :enemies, :list/label "Enemies", :list/people [[:person/id 3] [:person/id 4]]}}}

