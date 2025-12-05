Feature: DGMarkt Sorting Functionality

  Background:
    Given User is on the main login page and logs in
    Then The user should see the main page
    When the user locates the Category section on the homepage

  Scenario Outline:Verify product sorting for different categories and sort types
    Given The user navigates to the "<category>" category page
    When The user selects "<sortType>" from Sort By dropdown
    Then The products should be sorted by "<sortType>" in "<category>" category
    And The user should verify that dropdown shows "<sortType>" as selected option
    Examples:
      | category        | sortType           |
      | Health & Beauty | Default            |
      | Health & Beauty | Name (A - Z)       |
      | Health & Beauty | Name (Z - A)       |
      | Health & Beauty | Price (Low > High) |
      | Health & Beauty | Price (High > Low) |
      | Health & Beauty | Rating (Highest)   |
      | Health & Beauty | Rating (Lowest)    |
      | Health & Beauty | Model (A - Z)      |
      | Health & Beauty | Model (Z - A)      |

      | Televisions     | Default            |
      | Televisions     | Name (A - Z)       |
      | Televisions     | Name (Z - A)       |
      | Televisions     | Price (Low > High) |
      | Televisions     | Price (High > Low) |
      | Televisions     | Rating (Highest)   |
      | Televisions     | Rating (Lowest)    |
      | Televisions     | Model (A - Z)      |
      | Televisions     | Model (Z - A)      |

      | TV Accessories  | Default            |
      | TV Accessories  | Name (A - Z)       |
      | TV Accessories  | Name (Z - A)       |
      | TV Accessories  | Price (Low > High) |
      | TV Accessories  | Price (High > Low) |
      | TV Accessories  | Rating (Highest)   |
      | TV Accessories  | Rating (Lowest)    |
      | TV Accessories  | Model (A - Z)      |
      | TV Accessories  | Model (Z - A)      |

      | Networking      | Default            |
      | Networking      | Name (A - Z)       |
      | Networking      | Name (Z - A)       |
      | Networking      | Price (Low > High) |
      | Networking      | Price (High > Low) |
      | Networking      | Rating (Highest)   |
      | Networking      | Rating (Lowest)    |
      | Networking      | Model (A - Z)      |
      | Networking      | Model (Z - A)      |





