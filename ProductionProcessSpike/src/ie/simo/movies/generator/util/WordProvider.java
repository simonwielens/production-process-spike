package ie.simo.movies.generator.util;

import ie.simo.movies.util.RandomNumberProvider;

import java.util.Locale;
import java.util.Random;

public class WordProvider {
	private Random generator = RandomNumberProvider.getInstance();
	private String[] place = { "Space", "Paris", "LA", "New York", "Siberia",
			"Tokyo", "Japan", "a Cave", "the Bedroom", "the Kitchen",
			"the Street", "a Hole", "Holland", "Hong Kong", "Spain",
			"Portugal", "Timbuktu", "London", "Ireland", "the Bathroom",
			"the Attic", "the Basement", "the Swamp", "the Forest",
			"the Mountains", "the Mountain", "the Beach", "the Suburbs",
			"the Ghetto", "South Central", "the Farm", "the Factory",
			"the Nuclear Plant", "Mount Everest", "the Amazon", "the jungle",
			"the 7-11", "the Adult bookstore", "the Air Force base",
			"the Airport", "the Amusement park", "the Antique store",
			"the Apartment building", "the Arcade", "the Archaeological dig",
			"the Archery range", "the Art supply store",
			"the Auto wrecking yard", "the Bakery", "the Ball park",
			"the Bank", "the Bar", "the Barbershop", "the Beach",
			"the Beauty parlor", "the Bed and breakfast",
			"the Billiard parlor", "the Bookstore", "the Boutique",
			"the Bowling alley", "the Cabin", "the Cafe", "the Cathedral",
			"the Cemetery", "the Church", "the City Hall", "the Clinic",
			"the Computer store", "the Copy shop", "the Cruise ship",
			"the Dance club", "the Day care center", "the Delicatessen",
			"the Dentist's office", "the Discount store", "the Dormitory",
			"the Duplex", "the Elementary school", "the Farm",
			"the Fast food restaurant", "the Fishing boat", "the Gas station",
			"the Gift shop", "the Golf course", "the Greenhouse",
			"the Grocery store", "the Haunted house", "the Health food store",
			"the High school", "the Hospital", "the Hotel",
			"the House of ill repute", "the Inn", "the Jail",
			"the Junior high school", "the Junkyard", "the Library",
			"the Middle school", "the Mobile home park", "the Monastery",
			"the Mortuary", "the Motel", "the Museum", "the Music store",
			"the Newspaper office", "the Ocean liner",
			"the Office supply store", "the Office building", "the Park",
			"the Parking garage", "the Parking lot", "the Pastry shop",
			"the Pet store", "the Pharmacy", "the Pizza place",
			"the Planetarium", "the Post Office", "the Public restroom",
			"the Radio station", "the Record store", "the Restaurant",
			"the Retirement home", "the Seaside resort", "the Shoe store",
			"the Shopping mall", "the Slum", "the Souvenir shop",
			"the Stadium", "the State capitol building", "the Synagogue",
			"the Tattoo parlor", "the Temple", "the Theater", "the Toolshed",
			"the TV station", "the University", "the Used car lot",
			"the Video store", "the YMCA" };

	private String[] adjective = { "aback", "abaft", "abandoned", "abashed",
			"aberrant", "abhorrent", "abiding", "abject", "ablaze", "able",
			"abnormal", "aboard", "aboriginal", "abortive", "abounding",
			"abrasive", "abrupt", "absent", "absorbed", "absorbing",
			"abstracted", "absurd", "abundant", "abusive", "acceptable",
			"accessible", "accidental", "accurate", "acid", "acidic",
			"acoustic", "acrid", "actually", "ad hoc", "adamant", "adaptable",
			"addicted", "adhesive", "adjoining", "adorable", "adventurous",
			"afraid", "aggressive", "agonizing", "agreeable", "ahead", "ajar",
			"alcoholic", "alert", "alike", "alive", "alleged", "alluring",
			"aloof", "amazing", "ambiguous", "ambitious", "amuck", "amused",
			"amusing", "ancient", "angry", "animated", "annoyed", "annoying",
			"anxious", "apathetic", "aquatic", "aromatic", "arrogant",
			"ashamed", "aspiring", "assorted", "astonishing", "attractive",
			"auspicious", "automatic", "available", "average", "awake",
			"aware", "awesome", "awful", "axiomatic", "bad", "barbarous",
			"bashful", "bawdy", "beautiful", "befitting", "belligerent",
			"beneficial", "bent", "berserk", "best", "better", "bewildered",
			"big", "billowy", "bite-sized", "bitter", "bizarre", "black",
			"black-and-white", "bloody", "blue", "blue-eyed", "blushing",
			"boiling", "boorish", "bored", "boring", "bouncy", "boundless",
			"brainy", "brash", "brave", "brawny", "breakable", "breezy",
			"brief", "bright", "broad", "broken", "brown", "bumpy", "burly",
			"bustling", "busy", "cagey", "calculating", "callous", "calm",
			"capable", "capricious", "careful", "careless", "caring",
			"cautious", "ceaseless", "certain", "changeable", "charming",
			"cheap", "cheerful", "chemical", "chief", "childlike", "chilly",
			"chivalrous", "chubby", "chunky", "clammy", "classy", "clean",
			"clear", "clever", "cloistered", "cloudy", "closed", "clumsy",
			"cluttered", "coherent", "cold", "colorful", "colossal",
			"combative", "comfortable", "common", "complete", "complex",
			"concerned", "condemned", "confused", "conscious", "cooing",
			"cool", "cooperative", "coordinated", "courageous", "cowardly",
			"crabby", "craven", "crazy", "creepy", "crooked", "crowded",
			"cruel", "cuddly", "cultured", "cumbersome", "curious", "curly",
			"curved", "curvy", "cut", "cute", "cynical", "daffy", "daily",
			"damaged", "damaging", "damp", "dangerous", "dapper", "dark",
			"dashing", "dazzling", "dead", "deadpan", "deafening", "dear",
			"debonair", "decisive", "decorous", "deep", "deeply", "defeated",
			"defective", "defiant", "delicate", "delicious", "delightful",
			"demonic", "delirious", "dependent", "depressed", "deranged",
			"descriptive", "deserted", "detailed", "determined", "devilish",
			"didactic", "different", "difficult", "diligent", "direful",
			"dirty", "disagreeable", "disastrous", "discreet", "disgusted",
			"disgusting", "disillusioned", "dispensable", "distinct",
			"disturbed", "divergent", "dizzy", "domineering", "doubtful",
			"drab", "draconian", "dramatic", "dreary", "drunk", "dry", "dull",
			"dusty", "dynamic", "dysfunctional", "eager", "early",
			"earsplitting", "earthy", "easy", "eatable", "economic",
			"educated", "efficacious", "efficient", "eight", "elastic",
			"elated", "elderly", "electric", "elegant", "elfin", "elite",
			"embarrassed", "eminent", "empty", "enchanted", "enchanting",
			"encouraging", "endurable", "energetic", "enormous",
			"entertaining", "enthusiastic", "envious", "equable", "equal",
			"erect", "erratic", "ethereal", "evanescent", "evasive", "even",
			"excellent", "excited", "exciting", "exclusive", "exotic",
			"expensive", "extra-large", "extra-small", "exuberant", "exultant",
			"fabulous", "faded", "faint", "fair", "faithful", "fallacious",
			"false", "familiar", "famous", "fanatical", "fancy", "fantastic",
			"far", "far-flung", "fascinated", "fast", "fat", "faulty",
			"fearful", "fearless", "feeble", "feigned", "female", "fertile",
			"festive", "few", "fierce", "filthy", "fine", "finicky", "first",
			"five", "fixed", "flagrant", "flaky", "flashy", "flat", "flawless",
			"flimsy", "flippant", "flowery", "fluffy", "fluttering", "foamy",
			"foolish", "foregoing", "forgetful", "fortunate", "four", "frail",
			"fragile", "frantic", "free", "freezing", "frequent", "fresh",
			"fretful", "friendly", "frightened", "frightening", "full",
			"fumbling", "functional", "funny", "furry", "furtive", "future",
			"futuristic", "fuzzy", "gabby", "gainful", "gamy", "gaping",
			"garrulous", "gaudy", "general", "gentle", "giant", "giddy",
			"gifted", "gigantic", "glamorous", "gleaming", "glib",
			"glistening", "glorious", "glossy", "godly", "good", "goofy",
			"gorgeous", "graceful", "grandiose", "grateful", "gratis", "gray",
			"greasy", "great", "greedy", "green", "grey", "grieving", "groovy",
			"grotesque", "grouchy", "grubby", "gruesome", "grumpy", "guarded",
			"guiltless", "gullible", "gusty", "guttural", "habitual", "half",
			"hallowed", "halting", "handsome", "handsomely", "handy",
			"hanging", "hapless", "happy", "hard", "hard-to-find",
			"harmonious", "harsh", "hateful", "heady", "healthy",
			"heartbreaking", "heavenly", "heavy", "hellish", "helpful",
			"helpless", "hesitant", "hideous", "high", "highfalutin",
			"high-pitched", "hilarious", "hissing", "historical", "holistic",
			"hollow", "homeless", "homely", "honorable", "horrible",
			"hospitable", "hot", "huge", "hulking", "humdrum", "humorous",
			"hungry", "hurried", "hurt", "hushed", "husky", "hypnotic",
			"hysterical", "icky", "icy", "idiotic", "ignorant", "ill",
			"illegal", "ill-fated", "ill-informed", "illustrious", "imaginary",
			"immense", "imminent", "impartial", "imperfect", "impolite",
			"important", "imported", "impossible", "incandescent",
			"incompetent", "inconclusive", "industrious", "incredible",
			"inexpensive", "infamous", "innate", "innocent", "inquisitive",
			"insidious", "instinctive", "intelligent", "interesting",
			"internal", "invincible", "irate", "irritating", "itchy", "jaded",
			"jagged", "jazzy", "jealous", "jittery", "jobless", "jolly",
			"joyous", "judicious", "juicy", "jumbled", "jumpy", "juvenile",
			"kaput", "keen", "kind", "kindhearted", "kindly", "knotty",
			"knowing", "knowledgeable", "known", "labored", "lackadaisical",
			"lacking", "lame", "lamentable", "languid", "large", "last",
			"late", "laughable", "lavish", "lazy", "lean", "learned", "left",
			"legal", "lethal", "level", "lewd", "light", "like", "likeable",
			"limping", "literate", "little", "lively", "living", "lonely",
			"long", "longing", "long-term", "loose", "lopsided", "loud",
			"loutish", "lovely", "loving", "low", "lowly", "lucky",
			"ludicrous", "lumpy", "lush", "luxuriant", "lying", "lyrical",
			"macabre", "macho", "maddening", "madly", "magenta", "magical",
			"magnificent", "majestic", "makeshift", "male", "malicious",
			"mammoth", "maniacal", "many", "marked", "massive", "married",
			"marvelous", "material", "materialistic", "mature", "mean",
			"measly", "meaty", "medical", "meek", "mellow", "melodic",
			"melted", "merciful", "mere", "messy", "mighty", "military",
			"milky", "mindless", "miniature", "minor", "miscreant", "misty",
			"mixed", "moaning", "modern", "moldy", "momentous", "motionless",
			"mountainous", "muddled", "mundane", "murky", "mushy", "mute",
			"mysterious", "naive", "nappy", "narrow", "nasty", "natural",
			"naughty", "nauseating", "near", "neat", "nebulous", "necessary",
			"needless", "needy", "neighborly", "nervous", "new", "next",
			"nice", "nifty", "nimble", "nine", "nippy", "noiseless", "noisy",
			"nonchalant", "nondescript", "nonstop", "normal", "nostalgic",
			"nosy", "noxious", "null", "numberless", "numerous", "nutritious",
			"nutty", "oafish", "obedient", "obeisant", "obese", "obnoxious",
			"obscene", "obsequious", "observant", "obsolete", "obtainable",
			"oceanic", "odd", "offbeat", "old", "old-fashioned", "omniscient",
			"one", "onerous", "open", "opposite", "optimal", "orange",
			"ordinary", "organic", "ossified", "outgoing", "outrageous",
			"outstanding", "oval", "overconfident", "overjoyed", "overrated",
			"overt", "overwrought", "painful", "painstaking", "pale", "paltry",
			"panicky", "panoramic", "parallel", "parched", "parsimonious",
			"past", "pastoral", "pathetic", "peaceful", "penitent", "perfect",
			"periodic", "permissible", "perpetual", "petite", "phobic",
			"physical", "picayune", "pink", "piquant", "placid", "plain",
			"plant", "plastic", "plausible", "pleasant", "plucky", "pointless",
			"poised", "polite", "political", "poor", "possessive", "possible",
			"powerful", "precious", "premium", "present", "pretty", "previous",
			"pricey", "prickly", "private", "probable", "productive",
			"profuse", "protective", "proud", "psychedelic", "psychotic",
			"public", "puffy", "pumped", "puny", "purple", "purring", "pushy",
			"puzzled", "puzzling", "quack", "quaint", "quarrelsome",
			"questionable", "quick", "quickest", "quiet", "quirky", "quixotic",
			"quizzical", "rabid", "racial", "ragged", "rainy", "rambunctious",
			"rampant", "rapid", "rare", "raspy", "ratty", "ready", "real",
			"rebel", "receptive", "recondite", "red", "redundant",
			"reflective", "regular", "relieved", "remarkable", "reminiscent",
			"repulsive", "resolute", "resonant", "responsible", "rhetorical",
			"rich", "right", "righteous", "rightful", "rigid", "ripe", "ritzy",
			"roasted", "robust", "romantic", "roomy", "rotten", "rough",
			"round", "royal", "ruddy", "rude", "rural", "rustic", "ruthless",
			"sable", "sad", "safe", "salty", "same", "sassy", "satisfying",
			"savory", "scandalous", "scarce", "scared", "scary", "scattered",
			"scientific", "scintillating", "scrawny", "screeching", "second",
			"second-hand", "secret", "secretive", "sedate", "seemly",
			"selective", "selfish", "separate", "serious", "shaggy", "shaky",
			"shallow", "sharp", "shiny", "shivering", "shocking", "short",
			"shrill", "shut", "shy", "sick", "silent", "silky", "silly",
			"simple", "simplistic", "sincere", "six", "skillful", "skinny",
			"sleepy", "slim", "slimy", "slippery", "sloppy", "slow", "small",
			"smart", "smelly", "smiling", "smoggy", "smooth", "sneaky",
			"snobbish", "snotty", "soft", "soggy", "solid", "somber",
			"sophisticated", "sordid", "sore", "sour", "sparkling", "special",
			"spectacular", "spicy", "spiffy", "spiky", "spiritual", "spiteful",
			"splendid", "spooky", "spotless", "spotted", "spotty", "spurious",
			"squalid", "square", "squealing", "squeamish", "staking", "stale",
			"standing", "statuesque", "steadfast", "steady", "steep",
			"stereotyped", "sticky", "stiff", "stimulating", "stingy",
			"stormy", "straight", "strange", "striped", "strong", "stupendous",
			"stupid", "sturdy", "subdued", "subsequent", "substantial",
			"successful", "succinct", "sudden", "sulky", "super", "superb",
			"superficial", "supreme", "swanky", "sweet", "sweltering", "swift",
			"symptomatic", "synonymous", "taboo", "tacit", "tacky", "talented",
			"tall", "tame", "tan", "tangible", "tangy", "tart", "tasteful",
			"tasteless", "tasty", "tawdry", "tearful", "tedious", "teeny",
			"teeny-tiny", "telling", "temporary", "ten", "tender", "tense",
			"tenuous", "terrible", "terrific", "tested", "testy", "thankful",
			"therapeutic", "thick", "thin", "thinkable", "third", "thirsty",
			"thoughtful", "thoughtless", "threatening", "three", "thundering",
			"tidy", "tight", "tightfisted", "tiny", "tired", "tiresome",
			"toothsome", "torpid", "tough", "towering", "tranquil", "trashy",
			"tremendous", "tricky", "trite", "troubled", "truculent", "true",
			"truthful", "two", "typical", "ubiquitous", "ugliest", "ugly",
			"ultra", "unable", "unaccountable", "unadvised", "unarmed",
			"unbecoming", "unbiased", "uncovered", "understood", "undesirable",
			"unequal", "unequaled", "uneven", "unhealthy", "uninterested",
			"unique", "unkempt", "unknown", "unnatural", "unruly", "unsightly",
			"unsuitable", "untidy", "unused", "unusual", "unwieldy",
			"unwritten", "upbeat", "uppity", "upset", "uptight", "used",
			"useful", "useless", "utopian", "utter", "uttermost", "vacuous",
			"vagabond", "vague", "valuable", "various", "vast", "vengeful",
			"venomous", "verdant", "versed", "victorious", "vigorous",
			"violent", "violet", "vivacious", "voiceless", "volatile",
			"voracious", "vulgar", "wacky", "waggish", "waiting", "wakeful",
			"wandering", "wanting", "warlike", "warm", "wary", "wasteful",
			"watery", "weak", "wealthy", "weary", "well-groomed", "well-made",
			"well-off", "well-to-do", "wet", "whimsical", "whispering",
			"white", "whole", "wholesale", "wicked", "wide", "wide-eyed",
			"wiggly", "wild", "willing", "windy", "wiry", "wise", "wistful",
			"witty", "woebegone", "womanly", "wonderful", "wooden", "woozy",
			"workable", "worried", "worthless", "wrathful", "wretched",
			"wrong", "wry", "yellow", "yielding", "young", "youthful",
			"yummy 	", "zany", "zealous", "zesty", "zippy", "zonked",
			"aggressive", "blue-eyed", "cloudy", "dull", "gleaming", "light",
			"muddy", "shiny", "ugly", "alive", "breakable", "concerned",
			"doubtful", "gifted", "impossible", "odd", "puzzled", "talented",
			"wandering", "arrogant", "bored", "creepy", "depressed",
			"embarrassed", "evil", "frightened", "hurt", "nasty", "outrageous",
			"tense", "upset", "amused", "comfortable", "eager", "enthusiastic",
			"fine", "happy", "kind", "perfect", "splendid", "vivacious",
			"chubby", "low", "steep", "great", "massive", "tall", "faint",
			"loud", "raspy", "squealing", "brief", "old-fashioned", "bitter",
			"sour", "tasteless", "grubby", "plastic", "shaky", "smooth",
			"uneven", "yummy", "broken", "cuddly", "filthy", "abundant",
			"substantial" };

	private String[] noun = { "aardvark", "air", "airplane", "airport",
			"alarm", "alligator", "alphabet", "ambulance", "animal", "ankle",
			"army", "answer", "ant", "antelope", "apple", "arm", "armchair",
			"arrow", "asparagus", "baby", "back", "backbone", "bacon", "badge",
			"badger", "bag", "bagpipe", "bait", "bakery", "ball", "balloon",
			"bamboo", "banana", "band", "bandana", "bangle", "banjo", "bank",
			"baseball", "basket", "basketball", "bat", "bath", "bathroom",
			"bathtub", "battery", "battle", "bay", "beach", "bead", "bean",
			"bear", "beard", "beast", "beat", "beauty", "beaver", "bed",
			"bedroom", "bee", "beef", "beetle", "bell", "belt", "bench",
			"beret", "berry", "bicycle", "bike", "bird", "birthday", "bite",
			"blade", "blanket", "block", "blood", "blouse", "blow", "board",
			"boat", "bobcat", "body", "bolt", "bone", "bonsai", "book",
			"bookcase", "booklet", "boot", "border", "bottle", "bottom",
			"boundary", "bow", "bowling", "box", "boy", "brain", "brake",
			"branch", "brass", "bread", "break", "breakfast", "breath",
			"brick", "bridge", "broccoli", "brochure", "brother", "brush",
			"bubble", "bucket", "building", "bulb", "bull", "bulldozer",
			"bumper", "bun", "bus", "bush", "butter", "button", "cabbage",
			"cactus", "cafe", "cake", "calculator", "calendar", "calf", "call",
			"camel", "camera", "camp", "candle", "canoe", "canvas", "cap",
			"captain", "car", "card", "cardboard", "cardigan", "carpenter",
			"carrot", "cartoon", "cat", "caterpillar", "cathedral", "cattle",
			"cauliflower", "cave", "CD", "ceiling", "celery", "cello",
			"cement", "cemetery", "cereal", "chain", "chair", "chalk",
			"channel", "character", "cheek", "cheese", "cheetah", "cherry",
			"chess", "chest", "chick", "chicken", "children", "chimpanzee",
			"chin", "chive", "chocolate", "church", "cicada", "cinema",
			"circle", "city", "clam", "clarinet", "click", "clock", "close",
			"closet", "cloth", "cloud", "cloudy", "coach", "coal", "coast",
			"coat", "cobweb", "cockroach", "cocoa", "coffee", "coil", "coin",
			"coke", "cold", "collar", "college", "colt", "comb", "comics",
			"comma", "computer", "copy", "corn", "cost", "cotton", "couch",
			"cougar", "country", "course", "court", "cousin", "cow", "crab",
			"crack", "cracker", "crate", "crayfish", "crayon", "cream",
			"creek", "cricket", "crocodile", "crop", "crow", "crowd", "crown",
			"cucumber", "cup", "cupboard", "curtain", "curve", "cushion",
			"cyclone", "dad", "daffodil", "daisy", "dance", "daughter", "day",
			"deer", "denim", "dentist", "desert", "desk", "dessert",
			"detective", "dew", "diamond", "dictionary", "dinghy", "dinosaur",
			"dirt", "dish", "dog", "doll", "dollar", "door", "dragon",
			"dragonfly", "drain", "drawer", "dream", "dress", "dresser",
			"drill", "drink", "drum", "dryer", "duck", "duckling", "dungeon",
			"dust", "eagle", "ear", "earth", "earthquake", "eel", "egg",
			"eggplant", "elbow", "elephant", "energy", "engine", "equipment",
			"evening", "eye", "eyebrow", "face", "fact", "factory", "fairies",
			"family", "fan", "fang", "farm", "fear", "feast", "feather",
			"feet", "ferryboat", "field", "fight", "finger", "fire",
			"fireplace", "fish", "flag", "flame", "flood", "floor", "flower",
			"flute", "fly", "foam", "fog", "food", "foot", "football",
			"forehead", "forest", "fork", "fountain", "fox", "frame",
			"freckle", "freezer", "frog", "frost", "fruit", "fuel", "fur",
			"furniture", "game", "garage", "garden", "garlic", "gas", "gate",
			"gear", "ghost", "giraffe", "girl", "glass", "glove", "glue",
			"goal", "goat", "gold", "goldfish", "golf", "gorilla",
			"government", "grape", "grass", "grasshopper", "grease", "grill",
			"group", "guitar", "gum", "gym", "gymnast", "hail", "hair",
			"haircut", "hall", "hamburger", "hammer", "hamster", "hand",
			"handball", "handle", "hardware", "harmonica", "harmony", "hat",
			"hate", "hawk", "head", "headlight", "health", "heart", "heat",
			"heaven", "hedge", "height", "helicopter", "helmet", "help", "hen",
			"hill", "hip", "hippopotamus", "history", "hockey", "hole",
			"holiday", "home", "honey", "hood", "hook", "horn", "horse",
			"hose", "hospital", "hour", "house", "hurricane", "hyena", "ice",
			"icicle", "idea", "ink", "insect", "instrument", "Internet",
			"invention", "iron", "island", "jacket", "jaguar", "jail", "jam",
			"jar", "jaw", "jeans", "jeep", "jelly", "jellyfish", "jet",
			"jewel", "joke", "journey", "judge", "judo", "juice", "jump",
			"jumper", "kangaroo", "karate", "kayak", "kettle", "key",
			"keyboard", "kick", "kiss", "kitchen", "kite", "kitten", "knee",
			"knife", "knight", "knot", "lace", "ladybug", "lake", "lamb",
			"lamp", "land", "lasagna", "laugh", "laundry", "leaf", "leather",
			"leek", "leg", "lemonade", "leopard", "letter", "lettuce",
			"library", "lift", "light", "lightning", "lily", "line", "lion",
			"lip", "lipstick", "liquid", "list", "litter", "lizard", "loaf",
			"lobster", "lock", "locket", "locust", "look", "lotion", "love",
			"lunch", "lynx", "macaroni", "machine", "magazine", "magic",
			"magician", "mail", "mailbox", "mailman", "makeup", "map",
			"marble", "mark", "market", "mascara", "mask", "match", "meal",
			"meat", "mechanic ", "medicine", "memory", "men", "menu",
			"message", "metal", "mice", "middle", "milk", "milkshake", "mint",
			"minute", "mirror", "mist", "mistake", "mitten", "Monday", "money",
			"monkey", "month", "moon", "morning", "mosquito", "motorboat",
			"motorcycle", "mountain", "mouse", "moustache", "mouth", "music",
			"mustard", "nail", "name", "napkin", "neck", "needle", "nest",
			"net", "news", "night", "noise", "noodle", "nose", "note",
			"notebook", "number", "nut", "oak", "oatmeal", "ocean", "octopus",
			"office", "oil", "olive", "onion", "orange", "orchestra",
			"ostrich", "otter", "oven", "owl", "ox", "oxygen", "oyster",
			"packet", "page", "pail", "pain", "paint", "pair", "pajamas",
			"pamphlet", "pan", "pancake", "panda", "pansy", "panther", "pants",
			"paper", "parcel", "parent", "park", "parrot", "party", "pasta",
			"paste", "pastry", "patch", "path", "pea", "peace", "peanut",
			"pear", "pedestrian", "pelican", "pen", "pencil", "pepper",
			"perfume", "person", "pest", "pet", "phone", "piano", "pickle",
			"picture", "pie", "pig", "pigeon", "pillow", "pilot", "pimple",
			"pin", "pipe", "pizza", "plane", "plant", "plantation", "plastic",
			"plate", "playground", "plot", "pocket", "poison", "police",
			"policeman", "pollution", "pond", "popcorn", "poppy", "porcupine",
			"postage", "postbox", "pot", "potato", "poultry", "powder",
			"power", "price", "printer", "prison", "pumpkin", "puppy",
			"pyramid", "queen", "question", "quicksand", "quill", "quilt",
			"rabbit", "radio", "radish", "raft", "rail", "railway", "rain",
			"rainbow", "raincoat", "rainstorm", "rake", "rat", "ravioli",
			"ray", "recorder", "rectangle", "refrigerator", "reindeer",
			"relatives", "restaurant", "reward", "rhinoceros", "rice",
			"riddle", "ring", "river", "road", "roast", "rock", "roll", "roof",
			"room", "rooster", "rose", "rowboat", "rubber", "sack", "sail",
			"sailboat", "sailor", "salad", "salmon", "salt", "sand",
			"sandwich", "sardine", "sauce", "sausage", "saw", "saxophone",
			"scarecrow", "scarf", "school", "scissors", "scooter", "scorpion",
			"screw", "screwdriver", "sea", "seagull", "seal", "seaplane",
			"seashore", "season", "seat", "second", "seed", "sentence",
			"servant", "shade", "shadow", "shallot", "shampoo", "shark",
			"shears", "sheep", "sheet", "shelf", "shell", "shield", "ship",
			"shirt", "shoe", "shoemaker", "shop", "shorts", "shoulder",
			"shovel", "show", "side", "sidewalk", "sign", "signature", "silk",
			"silver", "singer", "sink", "sister", "skin", "skirt", "sky",
			"sled", "slippers", "slope", "smoke", "snail", "snake", "sneeze",
			"snow", "snowflake", "snowman", "soap", "soccer", "sock", "sofa",
			"softball", "soldier", "son", "song", "sound", "soup", "soybean",
			"space", "spade", "spaghetti", "spark", "sparrow", "spear",
			"speedboat", "spider", "spike", "spinach", "sponge", "spoon",
			"spot", "sprout", "spy", "square", "squash", "squid", "squirrel",
			"stage", "staircase", "stamp", "star", "station", "steam", "steel",
			"stem", "step", "stew", "stick", "stitch", "stinger", "stomach",
			"stone", "stool", "stopsign", "stopwatch", "store", "storm",
			"story", "stove", "stranger", "straw", "stream", "string",
			"submarine", "sugar", "suit", "summer", "sun", "sunshine",
			"sunflower", "supermarket", "surfboard", "surname", "surprise",
			"sushi", "swallow", "swamp", "swan", "sweater", "sweatshirt",
			"sweets", "swing", "switch", "sword", "swordfish", "syrup",
			"table", "tabletop", "tadpole", "tail", "target", "tax", "taxi",
			"tea", "teacher", "team", "teeth", "television", "tennis", "tent",
			"textbook", "theater", "thistle", "thought", "thread", "throat",
			"throne", "thumb", "thunder", "thunderstorm", "ticket", "tie",
			"tiger", "tile", "time", "tire", "toad", "toast", "toe", "toilet",
			"tomato", "tongue", "tooth", "toothbrush", "toothpaste", "top",
			"tornado", "tortoise", "tower", "town", "toy", "tractor",
			"traffic", "trail", "train", "transport", "tray", "tree",
			"triangle", "trick", "trip", "trombone", "trouble", "trousers",
			"truck", "trumpet", "trunk", "t-shirt", "tub", "tuba", "tugboat",
			"tulip", "tuna", "tune", "Turkey", "turnip", "turtle", "TV",
			"twig", "twilight", "twine", "umbrella", "valley", "van", "vase",
			"vegetable", "veil", "vein", "vessel", "vest", "violin", "volcano",
			"volleyball", "vulture", "wall", "wallaby", "walrus", "washer",
			"wasp", "waste", "watch", "watchmaker", "water", "waterfall",
			"wave", "wax", "weapon", "weasel", "weather", "wedge", "whale",
			"wheel", "whip", "whistle", "wilderness", "willow", "wind",
			"wind chime", "window", "windscreen", "wing", "winter", "wire",
			"wish", "witch", "wolf", "woman", "wood", "wool", "word",
			"workshop", "worm", "wound", "wren", "wrench", "wrinkles", "wrist",
			"xylophone", "yacht", "yak", "yard", "yogurt", "zebra", "zipper",
			"zoo" };

	public String getNoun() {
		return nounify(random(noun));
	}

	public String getAdjective() {
		return nounify(random(adjective));
	}

	public String getLowerCaseAdjective() {
		return random(adjective);
	}

	public String getPlace() {
		return random(place);
	}

	/**
	 * Make the word look like a noun
	 * 
	 * @param word
	 * @return word with uppercase first char
	 */
	public String nounify(String word) {
		String firstLetter = "" + word.charAt(0);
		return firstLetter.toUpperCase(Locale.UK) + word.substring(1);
	}

	public String getPluralNoun() {
		String noun = getNoun();
		return (noun.charAt(noun.length() - 1) == 's') ? noun + "es" : noun
				+ "s";
	}

	private String random(String[] src) {
		return src[generator.nextInt(src.length)];
	}
}