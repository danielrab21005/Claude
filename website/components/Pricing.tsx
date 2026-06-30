const plans = [
  {
    name: "Starter",
    price: "$49",
    period: "/month",
    description: "For smaller congregations getting started with digital giving.",
    features: [
      "Up to 200 members",
      "Unlimited donations",
      "1 POS device (Android app)",
      "Event management (up to 10/month)",
      "Email receipts & tax statements",
      "Basic donation reports",
      "Email support",
    ],
    cta: "Start Free Trial",
    highlighted: false,
  },
  {
    name: "Growth",
    price: "$99",
    period: "/month",
    description: "For growing churches that need more devices and deeper insights.",
    features: [
      "Up to 1,000 members",
      "Unlimited donations",
      "5 POS devices",
      "Unlimited events",
      "SMS + email receipts",
      "Advanced analytics & custom reports",
      "Member giving history",
      "Priority support",
    ],
    cta: "Start Free Trial",
    highlighted: true,
  },
  {
    name: "Enterprise",
    price: "Custom",
    period: "",
    description: "For large congregations, denominations, or multi-site ministries.",
    features: [
      "Unlimited members",
      "Unlimited POS devices",
      "Multi-site dashboard",
      "Custom fund categories",
      "Dedicated account manager",
      "API access & integrations",
      "Custom onboarding & training",
      "SLA-backed uptime",
    ],
    cta: "Contact Sales",
    highlighted: false,
  },
];

export default function Pricing() {
  return (
    <section id="pricing" className="py-24 bg-slate-50">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="text-center mb-16">
          <p className="text-indigo-600 font-semibold text-sm uppercase tracking-widest mb-3">Pricing</p>
          <h2 className="text-3xl sm:text-4xl font-bold text-slate-900 mb-4">Simple, transparent pricing</h2>
          <p className="max-w-xl mx-auto text-slate-500 text-lg">
            No hidden fees. No per-transaction percentages. Just a flat monthly rate so you can plan your ministry budget with confidence.
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-3 gap-8 items-stretch">
          {plans.map((plan) => (
            <div
              key={plan.name}
              className={`relative rounded-2xl p-8 flex flex-col ${
                plan.highlighted
                  ? "bg-indigo-600 text-white shadow-2xl shadow-indigo-900/30 scale-105"
                  : "bg-white border border-slate-200"
              }`}
            >
              {plan.highlighted && (
                <div className="absolute -top-4 left-1/2 -translate-x-1/2">
                  <span className="bg-amber-400 text-amber-900 text-xs font-bold px-4 py-1.5 rounded-full">Most Popular</span>
                </div>
              )}

              <div className="mb-6">
                <h3 className={`font-bold text-lg mb-1 ${plan.highlighted ? "text-white" : "text-slate-900"}`}>{plan.name}</h3>
                <div className="flex items-end gap-1 mb-2">
                  <span className={`text-4xl font-black ${plan.highlighted ? "text-white" : "text-slate-900"}`}>{plan.price}</span>
                  <span className={`text-sm mb-1 ${plan.highlighted ? "text-indigo-200" : "text-slate-400"}`}>{plan.period}</span>
                </div>
                <p className={`text-sm ${plan.highlighted ? "text-indigo-200" : "text-slate-500"}`}>{plan.description}</p>
              </div>

              <ul className="space-y-3 mb-8 flex-1">
                {plan.features.map((f) => (
                  <li key={f} className="flex items-start gap-2 text-sm">
                    <svg
                      className={`w-4 h-4 mt-0.5 flex-shrink-0 ${plan.highlighted ? "text-indigo-300" : "text-indigo-600"}`}
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke="currentColor"
                    >
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2.5} d="M5 13l4 4L19 7" />
                    </svg>
                    <span className={plan.highlighted ? "text-indigo-100" : "text-slate-600"}>{f}</span>
                  </li>
                ))}
              </ul>

              <a
                href="#contact"
                className={`block text-center py-3 px-6 rounded-xl font-semibold text-sm transition-colors ${
                  plan.highlighted
                    ? "bg-white text-indigo-600 hover:bg-indigo-50"
                    : "bg-indigo-600 text-white hover:bg-indigo-700"
                }`}
              >
                {plan.cta}
              </a>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
